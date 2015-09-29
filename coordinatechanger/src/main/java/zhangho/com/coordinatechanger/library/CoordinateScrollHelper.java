package zhangho.com.coordinatechanger.library;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zhangho.com.coordinatechanger.library.Changer.Changer;
import zhangho.com.coordinatechanger.library.Builder.Builder;

/**
 * Created by zhangho on 2015/09/28.
 */
public class CoordinateScrollHelper {

    //TODO interface にする
    static final int HORIZONTAL = 0;
    static final int VERTICAL = 1;

    private int mOrientation = VERTICAL;

    private Map<View, List<Changer>> mCoordinateViews;

    private RecyclerView mRecyclerView;

    private int mMultiplierValue;

    public CoordinateScrollHelper() {
        mCoordinateViews = new HashMap<>();
    }

    private void onTargetScrolled(int move, int totalMove) {

        Log.d("", "onTargetScrolled move:" + move);
        Log.d("", "onTargetScrolled totalMove:" + totalMove);

        for (View v : mCoordinateViews.keySet()) {
            for (Changer animation : mCoordinateViews.get(v)) {
                animation.playScroll(v, mMultiplierValue, move, totalMove);
            }
        }
    }

    private void onTargetScrollStateChanged(boolean isDragging) {
        Log.d("", "onTargetScrollStateChanged isDragging:" + isDragging);
        for (View v : mCoordinateViews.keySet()) {
            for (Changer animation : mCoordinateViews.get(v)) {
                animation.playStateChange(isDragging);
            }
        }
    }

    public void addScrollView(int orientation, RecyclerView recyclerView, final int multiplierHeight) {
        this.mOrientation = orientation;
        this.mRecyclerView = recyclerView;
        this.mMultiplierValue = multiplierHeight;

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                if (position == 0) {
                    outRect.top = multiplierHeight;
                }
            }
        });
    }

    public void addScrollObserver(View view, Builder... builders) {
        List<Changer> animations = new ArrayList<>();
        for (Builder builder : builders) {
            animations.add(builder.build(view));
        }
        mCoordinateViews.put(view, animations);
    }

    public void setUp() {
        mRecyclerView.addOnScrollListener(new RecyclerScrollListener() {
            @Override
            public void onScroll(int dx, int dy, int moveDistanceX, int moveDistanceY) {

                if(mOrientation == HORIZONTAL) {
                    onTargetScrolled(dx, moveDistanceX);
                }else{
                    onTargetScrolled(dy, moveDistanceY);
                }
            }

            @Override
            public void onScrollStateChanged(boolean isDragging) {
                onTargetScrollStateChanged(isDragging);
            }
        });
    }
}

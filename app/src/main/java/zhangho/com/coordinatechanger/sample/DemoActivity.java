package zhangho.com.coordinatechanger.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zhangho.com.coordinatechanger.R;
import zhangho.com.coordinatechanger.library.Builder.TranslationRateChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;
import zhangho.com.coordinatechanger.library.CoordinateScrollHelper;

/**
 * Created by b05947 on 2015/09/28.
 */
public class DemoActivity extends AppCompatActivity {

    @Bind(R.id.fragment_demo_header)
    ImageView mImageView;
    @Bind(R.id.fragment_demo_list)
    RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;
    private CoordinateScrollHelper mCoordinateScrollHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo);

        ButterKnife.bind(this);

        // RecyclerViewの設定
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new DemoAdapter();
        mRecyclerView.setAdapter(mAdapter);


        mCoordinateScrollHelper = new CoordinateScrollHelper();

        //wait for layout load complete for obtain correct size.
        mImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                //set scrollview
                mCoordinateScrollHelper.addScrollView(1, mRecyclerView, mImageView.getHeight());

                //you need remove observer
                mImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                //set header action
                mCoordinateScrollHelper.addScrollObserver(mImageView,
                        new TranslationRateChangerBuilder()
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setSpeedOfRelative(0.5f)
                );


                //start listen
                mCoordinateScrollHelper.setUp();
            }
        });
    }

    // A method to find height of the status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
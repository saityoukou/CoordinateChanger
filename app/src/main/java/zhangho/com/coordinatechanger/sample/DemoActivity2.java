package zhangho.com.coordinatechanger.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zhangho.com.coordinatechanger.R;
import zhangho.com.coordinatechanger.library.Builder.AlphaChangerBuilder;
import zhangho.com.coordinatechanger.library.Builder.TransitionDrawableBuilder;
import zhangho.com.coordinatechanger.library.Builder.TranslationRateChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;
import zhangho.com.coordinatechanger.library.CoordinateScrollHelper;

/**
 * Created by b05947 on 2015/09/28.
 */
public class DemoActivity2 extends AppCompatActivity {

    @Bind(R.id.fragment_demo_header)
    ImageView mImageView;
    @Bind(R.id.fragment_demo_list)
    RecyclerView mRecyclerView;
    @Bind(R.id.fragment_demo_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.fragment_demo_title)
    TextView mTitle;

    private DemoAdapter mAdapter;
    private CoordinateScrollHelper mCoordinateScrollHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo2);

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
                                                ,
                        new AlphaChangerBuilder()
                                .setFromAlpha(1.0f)
                                .setToAlpha(0.0f)
                                .setDuration(500)
                                .setMultiplier(0.4f)
                );


                //mToolbar must set TranslationDrawable background while use TranslationDrawableBuilder
                mCoordinateScrollHelper.addScrollObserver(mToolbar,
                        new TransitionDrawableBuilder()
                            .setMultiplier(0.6f)
                            .setDuration(300)
                );

                //set toolbar title action
                mCoordinateScrollHelper.addScrollObserver(mTitle,
                        new AlphaChangerBuilder()
                                .setFromAlpha(0.0f)
                                .setToAlpha(1.0f)
                                .setDuration(500)
                                .setMultiplier(0.6f)
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
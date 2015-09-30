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
import zhangho.com.coordinatechanger.library.Builder.TransitionDrawableBuilder;
import zhangho.com.coordinatechanger.library.Builder.TranslationMoveBuilder;
import zhangho.com.coordinatechanger.library.Builder.TranslationRateChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;
import zhangho.com.coordinatechanger.library.CoordinateScrollHelper;

/**
 * Created by b05947 on 2015/09/28.
 */
public class DemoActivity4 extends AppCompatActivity {

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
        setContentView(R.layout.fragment_demo4);

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


                //mToolbar must set TranslationDrawable background while use TranslationDrawableBuilder
                mCoordinateScrollHelper.addScrollObserver(mToolbar,
                        new TransitionDrawableBuilder()
                                .setMultiplier(0.6f)
                                .setDuration(300)
                );

                //set toolbar title action
                mCoordinateScrollHelper.addScrollObserver(mTitle,
                        new TranslationMoveBuilder()
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setEndPositionX(4)
                                .setEndPositionY(mToolbar.getHeight() / 6)
                                .setEndScale(0.5f)
                );

                //start listen
                mCoordinateScrollHelper.setUp();
            }
        });
    }
}
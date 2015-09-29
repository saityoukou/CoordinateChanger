package zhangho.com.coordinatechanger.sample;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zhangho.com.coordinatechanger.R;
import zhangho.com.coordinatechanger.library.Builder.TranslationRateChangerBuilder;
import zhangho.com.coordinatechanger.library.Builder.TranslationShowToolbarChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;
import zhangho.com.coordinatechanger.library.CoordinateScrollHelper;
import zhangho.com.coordinatechanger.library.EventType;

/**
 * Created by b05947 on 2015/09/28.
 */
public class DemoActivity3 extends AppCompatActivity {

    @Bind(R.id.fragment_demo_header)
    ImageView mImageView;
    @Bind(R.id.fragment_demo_list)
    RecyclerView mRecyclerView;
    @Bind(R.id.fragment_demo_toolbar)
    Toolbar mToolbar;

    private DemoAdapter mAdapter;
    private CoordinateScrollHelper mCoordinateScrollHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo3);

        ButterKnife.bind(this);

        mToolbar.setNavigationIcon(R.drawable.ic_arrow);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        int statusBarHeight = 0;
        // Check if the version of Android is Lollipop or higher
        if (Build.VERSION.SDK_INT >= 21) {

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

            // Set paddingTop of toolbar to height of status bar.
            // Fixes statusbar covers toolbar issue
            statusBarHeight = getStatusBarHeight();
        }


        // RecyclerViewの設定
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new DemoAdapter();
        mRecyclerView.setAdapter(mAdapter);


        mCoordinateScrollHelper = new CoordinateScrollHelper();

        //wait for layout load complete for obtain correct size.
        final int finalStatusBarHeight = statusBarHeight;
        mImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                //set scrollview
                mCoordinateScrollHelper.addScrollView(1, mRecyclerView, mImageView.getHeight() - finalStatusBarHeight);

                //you need remove observer
                mImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                //set header action
                mCoordinateScrollHelper.addScrollObserver(mImageView,
                        new TranslationRateChangerBuilder()
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setSpeedOfRelative(0.5f)
                );

                //set header action
                mCoordinateScrollHelper.addScrollObserver(mToolbar,
                        new TranslationShowToolbarChangerBuilder()
                                .setScrollType(EventType.SCROLL_DOWN)
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setSpeedOfRelative(1f)
                        .setScrollHidePosition(mImageView.getHeight() - finalStatusBarHeight - mToolbar.getHeight())
                        ,
                        new TranslationShowToolbarChangerBuilder()
                                .setColor(R.color.colorPrimary)
                                .setScrollType(EventType.SCROLL_UP)
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setSpeedOfRelative(2f)
                                .setScrollHidePosition(mImageView.getHeight() - finalStatusBarHeight - mToolbar.getHeight())
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
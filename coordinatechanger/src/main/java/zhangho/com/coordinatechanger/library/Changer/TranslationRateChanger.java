package zhangho.com.coordinatechanger.library.Changer;

import android.util.Log;
import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.Builder;
import zhangho.com.coordinatechanger.library.Builder.TranslationRateChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;

/**
 * Created by b05947 on 2015/09/25.
 */
public class TranslationRateChanger extends BaseChanger {

    private TranslationRateChangerBuilder mBuilder;
    private TranslationRateChangerBuilder.TranslationRateChangerListener mListener;


    public TranslationRateChanger(TranslationRateChangerBuilder translationRateChangerBuilder) {
        mBuilder = translationRateChangerBuilder;
        mListener = mBuilder.getListener();
    }


    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {

        float translation = -totalMove * mBuilder.getSpeedOfRelative();

        if(mBuilder.getScrollHidePosition() != Builder.NO_VALUE){
            float diff = totalMove - mBuilder.getScrollHidePosition();


            if(diff < 0){
                diff = 0;
            }
            translation = -diff * mBuilder.getSpeedOfRelative();
        }

        Log.d("","translation:" + translation);



        if (mBuilder.getChangerType() == ChangerType.TRANSLATION_X) {
            v.setTranslationX(translation);
        } else {
            v.setTranslationY(translation);
        }

        if(mListener != null){
            mListener.onItemScroll(translation < 0);
        }

        return true;
    }
}

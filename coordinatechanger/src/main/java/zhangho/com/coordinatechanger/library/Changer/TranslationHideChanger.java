package zhangho.com.coordinatechanger.library.Changer;

import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.TranslationHideBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;

/**
 * Created by b05947 on 2015/09/25.
 */
public class TranslationHideChanger extends BaseChanger {

    private TranslationHideBuilder mBuilder;

    public TranslationHideChanger(TranslationHideBuilder translationHideBuilder) {
        mBuilder = translationHideBuilder;
    }

    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {

        float hidePosition = mBuilder.getScrollHidePosition();

        if(totalMove < hidePosition){
            return false;
        }

        float translation = - (totalMove - hidePosition);

        if (mBuilder.getChangerType() == ChangerType.TRANSLATION_X){
            v.setTranslationX(translation);
        }else{
            v.setTranslationY(translation);
        }

        return true;
    }
}

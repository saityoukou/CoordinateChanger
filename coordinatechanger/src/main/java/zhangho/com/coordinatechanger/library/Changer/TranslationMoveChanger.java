package zhangho.com.coordinatechanger.library.Changer;

import android.util.Log;
import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.TranslationMoveBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;

/**
 * Created by b05947 on 2015/09/25.
 */
public class TranslationMoveChanger extends BaseChanger {

    private TranslationMoveBuilder mBuilder;

    private float startPositionX;
    private float startPositionY;
    private float endPositionX;
    private float endPositionY;
    private float startScale = 1f;
    private float endScale;
    private ChangerType changerType;

    public TranslationMoveChanger(View v, TranslationMoveBuilder translationMoveBuilder) {
        mBuilder = translationMoveBuilder;

        startPositionX = v.getX();
        startPositionY = v.getY();
        endPositionX = mBuilder.getEndPositionX();
        endPositionY = mBuilder.getEndPositionY();
        endScale = mBuilder.getEndScale();
        changerType = mBuilder.getChangerType();
    }

    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {


        float percent = 0f;
        if(ChangerType.TRANSLATION_X == changerType){
            percent = totalMove/ (startPositionX - endPositionX);
        }else if(ChangerType.TRANSLATION_Y == changerType){
            percent = totalMove/ (startPositionY - endPositionY);
        }

        Log.d("", "percent:" + percent);
        if(percent > 1f) {
            return false;
        }

        float scale = startScale - (startScale - endScale) * percent;
        float transX = startPositionX - (startPositionX - endPositionX) * percent;
        float transY = startPositionY - (startPositionY - endPositionY) * percent;

        Log.d("", "transX:" + transX);
        Log.d("", "transY:" + transY);


        v.setScaleX(scale);
        v.setScaleY(scale);

        v.setX(transX);
        v.setY(transY);

        return true;
    }
}

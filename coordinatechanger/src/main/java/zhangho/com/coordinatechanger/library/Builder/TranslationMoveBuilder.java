package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TranslationMoveChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class TranslationMoveBuilder implements Builder {

    private ChangerType changerType;
    private float endPositionX = NO_VALUE;
    private float endPositionY = NO_VALUE;
    private float endScale = NO_VALUE;

    public TranslationMoveBuilder setChangerType(ChangerType changerType) {
        this.changerType = changerType;
        return this;
    }


    public ChangerType getChangerType() {
        return changerType;
    }

    public float getEndPositionX() {
        return endPositionX;
    }

    public TranslationMoveBuilder setEndPositionX(float endPositionX) {
        this.endPositionX = endPositionX;
        return this;
    }

    public float getEndScale() {
        return endScale;
    }

    public TranslationMoveBuilder setEndScale(float endScale) {
        this.endScale = endScale;
        return this;
    }

    public float getEndPositionY() {
        return endPositionY;
    }

    public TranslationMoveBuilder setEndPositionY(float endPositionY) {
        this.endPositionY = endPositionY;
        return this;
    }

    @Override
    public TranslationMoveChanger build(View v) {
        return new TranslationMoveChanger(v,this);
    }
}
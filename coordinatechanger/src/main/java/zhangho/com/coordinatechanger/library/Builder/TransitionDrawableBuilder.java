package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TransitionDrawableChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class TransitionDrawableBuilder implements Builder {

    private ChangerType changerType;
    private float multiplier = NO_VALUE;   //ほかViewアニメーションの発火になるポジション
    private int duration = -1; //継続時間

    public TransitionDrawableBuilder setChangerType(ChangerType changerType) {
        this.changerType = changerType;
        return this;
    }

    public ChangerType getChangerType() {
        return changerType;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public TransitionDrawableBuilder setMultiplier(float multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public TransitionDrawableBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public TransitionDrawableChanger build(View v) {
        return new TransitionDrawableChanger(v,this);
    }

}
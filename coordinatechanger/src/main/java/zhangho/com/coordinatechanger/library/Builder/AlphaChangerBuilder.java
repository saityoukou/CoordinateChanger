package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by zhangho on 2015/09/25.
 */


import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.AlphaChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class AlphaChangerBuilder implements Builder {

    private ChangerType changerType = ChangerType.ALPHA;
    private float fromAlpha = NO_VALUE;
    private float toAlpha = NO_VALUE;
    private long duration = -1; //継続時間
    private float multiplier = NO_VALUE;   //ほかViewアニメーションの発火になるポジション

    public AlphaChangerBuilder setFromAlpha(float fromAlpha) {
        this.fromAlpha = fromAlpha;
        return this;
    }

    public AlphaChangerBuilder setToAlpha(float toAlpha) {
        this.toAlpha = toAlpha;
        return this;
    }

    public AlphaChangerBuilder setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public AlphaChangerBuilder setMultiplier(float multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public ChangerType getChangerType() {
        return changerType;
    }

    public float getFromAlpha() {
        return fromAlpha;
    }

    public float getToAlpha() {
        return toAlpha;
    }

    public long getDuration() {
        return duration;
    }

    public float getMultiplier() {
        return multiplier;
    }

    @Override
    public AlphaChanger build(View v) {
        return new AlphaChanger(this);
    }
}
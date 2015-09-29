package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by zhangho on 2015/09/25.
 */


import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.BackgroundChanger;
import zhangho.com.coordinatechanger.library.ChangerType;

public class BackgroundChangerBuilder implements Builder {

    private ChangerType changerType = ChangerType.CHANGE_BACKGROUND;
    private int fromColor;
    private int toColor;
    private float multiplier = NO_VALUE;   //ほかViewアニメーションの発火になるポジション


    public ChangerType getChangerType() {
        return changerType;
    }

    public void setChangerType(ChangerType changerType) {
        this.changerType = changerType;
    }

    public int getFromColor() {
        return fromColor;
    }

    public BackgroundChangerBuilder setFromColor(int fromColor) {
        this.fromColor = fromColor;
        return this;
    }

    public int getToColor() {
        return toColor;
    }

    public BackgroundChangerBuilder setToColor(int toColor) {
        this.toColor = toColor;
        return this;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public BackgroundChangerBuilder setMultiplier(float multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    @Override
    public BackgroundChanger build(View v) {
        return new BackgroundChanger(this);
    }
}
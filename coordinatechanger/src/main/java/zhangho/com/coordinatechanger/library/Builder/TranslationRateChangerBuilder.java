package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TranslationRateChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class TranslationRateChangerBuilder implements Builder {

    protected ChangerType changerType;
    protected float speedOfRelative = NO_VALUE;  //Scrollの移動に比べての速度
    protected float scrollHidePosition = NO_VALUE;
    private int color;
    private TranslationRateChangerListener mListener;

    public interface TranslationRateChangerListener{
        void onItemScroll(boolean isScrollUp);
    }

    public TranslationRateChangerBuilder setChangerType(ChangerType changerType) {
        this.changerType = changerType;
        return this;
    }

    public TranslationRateChangerBuilder setSpeedOfRelative(float speedOfRelative) {
        this.speedOfRelative = speedOfRelative;
        return this;
    }

    public ChangerType getChangerType() {
        return changerType;
    }

    public float getSpeedOfRelative() {
        return speedOfRelative;
    }

    public float getScrollHidePosition() {
        return scrollHidePosition;
    }

    public TranslationRateChangerBuilder setScrollHidePosition(float scrollHidePosition) {
        this.scrollHidePosition = scrollHidePosition;
        return this;
    }


    public TranslationRateChangerListener getListener() {
        return mListener;
    }

    public TranslationRateChangerBuilder setListener(TranslationRateChangerListener listener) {
        this.mListener = listener;
        return this;
    }

    @Override
    public TranslationRateChanger build(View v) {
        return new TranslationRateChanger(this);
    }

}
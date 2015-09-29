package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TranslationChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class TranslationChangerBuilder implements Builder {

    private ChangerType changerType;
    private float scrollHidePosition = NO_VALUE;

    public TranslationChangerBuilder setChangerType(ChangerType changerType) {
        this.changerType = changerType;
        return this;
    }


    public ChangerType getChangerType() {
        return changerType;
    }

    public float getScrollHidePosition() {
        return scrollHidePosition;
    }

    public TranslationChangerBuilder setScrollHidePosition(float scrollHidePosition) {
        this.scrollHidePosition = scrollHidePosition;
        return this;
    }

    @Override
    public TranslationChanger build(View v) {
        return new TranslationChanger(this);
    }
}
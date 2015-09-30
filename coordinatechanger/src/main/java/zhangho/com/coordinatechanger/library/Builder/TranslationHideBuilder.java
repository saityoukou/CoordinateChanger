package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TranslationHideChanger;
import zhangho.com.coordinatechanger.library.ChangerType;


public class TranslationHideBuilder implements Builder {

    private ChangerType changerType;
    private float scrollHidePosition = NO_VALUE;

    public TranslationHideBuilder setChangerType(ChangerType changerType) {
        this.changerType = changerType;
        return this;
    }


    public ChangerType getChangerType() {
        return changerType;
    }

    public float getScrollHidePosition() {
        return scrollHidePosition;
    }

    public TranslationHideBuilder setScrollHidePosition(float scrollHidePosition) {
        this.scrollHidePosition = scrollHidePosition;
        return this;
    }

    @Override
    public TranslationHideChanger build(View v) {
        return new TranslationHideChanger(this);
    }
}
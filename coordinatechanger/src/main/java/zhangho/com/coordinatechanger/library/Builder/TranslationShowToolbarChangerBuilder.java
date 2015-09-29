package zhangho.com.coordinatechanger.library.Builder;

/**
 * Created by b05947 on 2015/09/25.
 */

import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.TranslationShowToolbarChanger;
import zhangho.com.coordinatechanger.library.EventType;


public class TranslationShowToolbarChangerBuilder extends TranslationRateChangerBuilder {

    private EventType scrollType = EventType.SCROLL_ALL;
    private int color;
    private TranslationShowToolbarChangerListener mListener;


    public interface TranslationShowToolbarChangerListener{
        void onItemScroll(boolean isScrollUp);
    }

    public TranslationShowToolbarChangerBuilder setScrollType(EventType scrollType) {
        this.scrollType = scrollType;
        return this;
    }

    public EventType getScrollType() {
        return scrollType;
    }

    public int getColor() {
        return color;
    }

    public TranslationShowToolbarChangerBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    public TranslationShowToolbarChangerListener getToolbarListener() {
        return mListener;
    }

    public TranslationShowToolbarChangerBuilder setToolbarListener(TranslationShowToolbarChangerListener toolbarListener) {
        this.mListener = toolbarListener;

        setListener(new TranslationRateChangerListener() {
            @Override
            public void onItemScroll(boolean isScrollUp) {

            }
        });
        return this;
    }


    @Override
    public TranslationShowToolbarChanger build(View v) {
        return new TranslationShowToolbarChanger(v,this);
    }

}
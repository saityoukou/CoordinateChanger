package zhangho.com.coordinatechanger.library.Changer;

import android.util.Log;
import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.TranslationShowToolbarChangerBuilder;
import zhangho.com.coordinatechanger.library.ChangerType;
import zhangho.com.coordinatechanger.library.EventType;

/**
 * Created by b05947 on 2015/09/25.
 */
public class TranslationShowToolbarChanger extends TranslationRateChanger {

    private TranslationShowToolbarChangerBuilder mBuilder;
    private View mView;
    private int mHeight;
    private int mActionDownPosition;
    private TranslationShowToolbarChangerBuilder.TranslationShowToolbarChangerListener mListener;

    public TranslationShowToolbarChanger(View v, TranslationShowToolbarChangerBuilder translationShowToolbarChangerBuilder) {
        super(translationShowToolbarChangerBuilder);
        mBuilder = translationShowToolbarChangerBuilder;
        mView = v;
        mHeight = mView.getHeight();
        mListener = mBuilder.getToolbarListener();
    }

    @Override
    public boolean playStateChange(boolean isDragging) {
        mActionDownPosition = 0;
        return false;
    }

    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {


        if(mBuilder.getScrollType() == EventType.SCROLL_DOWN && move > 0){
            super.playScroll(v, multiplierValue, move, totalMove);
            return true;
        }else if(mBuilder.getScrollType() == EventType.SCROLL_UP && move < 0) {

            //set background to colorPrimary
            v.setBackgroundColor(v.getResources().getColor(mBuilder.getColor()));

            mActionDownPosition += move;
            int diff = - mHeight + Math.abs(mActionDownPosition);

            Log.d("","mActionDownPosition:" + mActionDownPosition);
            Log.d("","mHeight:" + mHeight);

            if(diff > 0){
                diff = 0;
            }

            if (mBuilder.getChangerType() == ChangerType.TRANSLATION_X) {
                v.setTranslationX(diff);
            } else {
                v.setTranslationY(diff);
            }
        }
        return true;
    }
}

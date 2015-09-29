package zhangho.com.coordinatechanger.library.Changer;

import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.TransitionDrawableBuilder;

/**
 * Created by b05947 on 2015/09/25.
 */
public class TransitionDrawableChanger extends BaseChanger {

    private TransitionDrawableBuilder mBuilder;
    TransitionDrawable mTransition;

    public TransitionDrawableChanger(View v, TransitionDrawableBuilder transitionDrawableBuilder) {
        mBuilder = transitionDrawableBuilder;
        mTransition = (TransitionDrawable)v.getBackground();
    }

    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {

        float multiplier = mBuilder.getMultiplier() * multiplierValue;

        Log.d("","multiplier:" + multiplier);
        Log.d("","totalMove:" + totalMove);
        Log.d("","mProgress:" + mProgress);


        if (totalMove > multiplier) {
            if(mProgress <= 1) {
                mTransition.startTransition(mBuilder.getDuration());
            }
        }else{
            if(mProgress >= 1) {
                mTransition.reverseTransition(mBuilder.getDuration());
            }
        }

        mProgress = totalMove / multiplier;
        return true;
    }
}

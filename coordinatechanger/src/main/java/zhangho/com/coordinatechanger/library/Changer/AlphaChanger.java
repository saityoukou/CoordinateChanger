package zhangho.com.coordinatechanger.library.Changer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.AlphaChangerBuilder;

/**
 * Created by b05947 on 2015/09/25.
 */
public class AlphaChanger extends BaseChanger {

    protected AlphaChangerBuilder mBuilder;
    protected ObjectAnimator mAnimator;
    protected boolean mIsAnimating;

    public AlphaChanger(AlphaChangerBuilder alphaChangerBuilder) {
        mBuilder = alphaChangerBuilder;
        setUp();
    }

    private void setUp() {
        mIsAnimating = false;
        mAnimator = new ObjectAnimator();
        mAnimator.setPropertyName("alpha");
        mAnimator.setDuration(mBuilder.getDuration());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mIsAnimating = false;
            }
        });
    }

    @Override
    public boolean playScroll(View v, int multiplierValue, int move, int totalMove) {
        if (!mIsAnimating) {

            Log.d("", "mBuilder.getMultiplier() * multiplierValue:" + mBuilder.getMultiplier() * multiplierValue);

            //from->toにalphaを変える。
            if (totalMove > mBuilder.getMultiplier() * multiplierValue) {
                if (v.getAlpha() == mBuilder.getToAlpha()) {
                    return false;
                }
                mAnimator.setFloatValues(mBuilder.getFromAlpha(), mBuilder.getToAlpha());
            }
            //to->fromにalphaを変える
            else {
                if (v.getAlpha() == mBuilder.getFromAlpha()) {
                    return false;
                }
                mAnimator.setFloatValues(mBuilder.getToAlpha(), mBuilder.getFromAlpha());
            }
            mAnimator.setTarget(v);
            mAnimator.start();
            mIsAnimating = true;
            return true;
        }
        return false;
    }
}

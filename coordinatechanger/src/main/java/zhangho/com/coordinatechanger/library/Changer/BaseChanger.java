package zhangho.com.coordinatechanger.library.Changer;

import android.view.View;

/**
 * Created by b05947 on 2015/09/29.
 */
public class BaseChanger implements Changer {

    float mProgress;

    @Override
    public boolean playScroll(View view, int multiplierValue, int move, int totalMove) {
        return false;
    }

    @Override
    public boolean playStateChange(boolean isDragging) {
        return false;
    }
}

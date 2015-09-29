package zhangho.com.coordinatechanger.library.Changer;

import android.view.View;

/**
 * Created by b05947 on 2015/09/25.
 */
public interface Changer {
    boolean playScroll(View view, int multiplierValue, int move, int totalMove);
    boolean playStateChange(boolean isDragging);
}

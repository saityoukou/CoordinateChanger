package zhangho.com.coordinatechanger.library.Builder;


import android.view.View;

import zhangho.com.coordinatechanger.library.Changer.Changer;

/**
 * Created by b05947 on 2015/09/25.
 */
public interface Builder {

    public static final float NO_VALUE = Float.MIN_VALUE;

    public Changer build(View v);
}

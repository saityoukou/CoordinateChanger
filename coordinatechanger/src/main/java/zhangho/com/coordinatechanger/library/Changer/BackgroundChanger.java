package zhangho.com.coordinatechanger.library.Changer;

import android.view.View;

import zhangho.com.coordinatechanger.library.Builder.BackgroundChangerBuilder;

/**
 * Created by b05947 on 2015/09/25.
 */
public class BackgroundChanger extends BaseChanger {

    private BackgroundChangerBuilder mBuilder;

    public BackgroundChanger(BackgroundChangerBuilder backgroundChangerBuilder) {
        mBuilder = backgroundChangerBuilder;
    }

    @Override
    public boolean playScroll(View v, int multiplierValue,  int move, int totalMove) {
        v.setBackgroundColor(
                        totalMove > mBuilder.getMultiplier() * multiplierValue
                                ? mBuilder.getToColor() : mBuilder.getFromColor()
        );
        return true;
    }
}

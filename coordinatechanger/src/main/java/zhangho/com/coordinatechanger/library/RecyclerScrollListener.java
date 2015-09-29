package zhangho.com.coordinatechanger.library;

import android.support.v7.widget.RecyclerView;

/**
 * Created by b05947 on 2015/09/25.
 */
public abstract class RecyclerScrollListener extends RecyclerView.OnScrollListener {

    private int moveDistanceX = 0;
    private int moveDistanceY = 0;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        moveDistanceX += dx;
        moveDistanceY += dy;

        onScroll(dx, dy, moveDistanceX, moveDistanceY);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState){
        if( RecyclerView.SCROLL_STATE_DRAGGING == newState){
            onScrollStateChanged(true);
        }else if( RecyclerView.SCROLL_STATE_IDLE == newState){
            onScrollStateChanged(false);
        }
    }

    public abstract void onScroll(int dx, int dy, int moveDistanceX, int moveDistanceY);
    public abstract void onScrollStateChanged(boolean isDragging);
}

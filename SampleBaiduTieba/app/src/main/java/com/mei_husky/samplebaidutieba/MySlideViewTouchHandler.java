package com.mei_husky.samplebaidutieba;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by QingMei on 2017/1/20 17:11
 * email:mei_husky@qq.com
 * desc:Used to  可拖拽的itemTouchHelper
 */

public class MySlideViewTouchHandler extends ItemTouchHelper.Callback {

    private ItemTouchAdapter adapter;

    public MySlideViewTouchHandler(@NonNull ItemTouchAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * 设置拖拽和删除的模式
     *
     * @param recyclerView rv
     * @param viewHolder   holder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags, swipeFlags;  //拖拽方向，滑动消失方向
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager || manager instanceof StaggeredGridLayoutManager) {
            //若是gird或者瀑布流布局，可以上下左右滑动
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        } else {
            //线性布局只能上下滑动
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        //左右方向滑动消失
        swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        //若值为0，说明不支持该功能
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /**
     * 拖拽后回调,一般通过接口暴露给adapter, 让adapter去处理数据的交换
     *
     * @param recyclerView rv
     * @param viewHolder   从某个view
     * @param target       到哪个view
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();   //getLayoutPosition()?
        //同一类型才可以
        if (viewHolder.getItemViewType() == target.getItemViewType()) {

            if (fromPosition > toPosition) {
                for (int i = fromPosition; i > toPosition; i--) {
                    adapter.onItemMove(i, i - 1);
                }
            } else {
                for (int i = fromPosition; i < toPosition; i++) {
                    adapter.onItemMove(i, i + 1);
                }
            }
        }
        adapter.notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    /**
     * 滑动删除后回调
     * @param viewHolder view
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    /**
     * item取消选中(取消长按)
     * 这里改变了 item的背景色, 也可以通过接口暴露, 让adapter去处理逻辑
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
        super.clearView(recyclerView, viewHolder);
    }

    /**
     * 是否支持长按开始拖拽,默认开启
     * 可以不开启,然后在长按 item 的时候,手动 调用 mItemTouchHelper.startDrag(myHolder) 开启,更加灵活
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return adapter.autoOpenDrag();
    }

    /**
     * 是否支持滑动删除,默认开启
     * 可以不开启,然后在长按 item 的时候,手动 调用 mItemTouchHelper.startSwipe(myHolder) 开启,更加灵活
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return adapter.autoOpenSwipe();
    }



    // 建议让 adapter 实现该接口
    public static abstract class ItemTouchAdapter extends RecyclerView.Adapter {

        public abstract void onItemMove(int fromPosition, int toPosition);

        public abstract void onItemRemove(int position);

        // 是否自动开启拖拽
        protected boolean autoOpenDrag() {
            return true;
        }

        // 是否自动开启滑动删除
        protected boolean autoOpenSwipe() {
            return false;
        }

    }
}

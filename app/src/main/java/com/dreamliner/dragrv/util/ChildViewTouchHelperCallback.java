package com.dreamliner.dragrv.util;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.dreamliner.dragrv.interfaces.CallbackItemTouch;

/**
 * @author chenzj
 * @Title: ChildViewTouchHelperCallback
 * @Description: 类的描述 -
 * @date 2016/11/22 18:37
 * @email admin@chenzhongjin.cn
 */
public class ChildViewTouchHelperCallback extends ItemTouchHelper.Callback {

    private final CallbackItemTouch mAdapter;
    private Context context;

    public ChildViewTouchHelperCallback(CallbackItemTouch adapter, Context context) {
        mAdapter = adapter;
        this.context = context;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);

    }

    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return animationType == ItemTouchHelper.ANIMATION_TYPE_DRAG ? DEFAULT_DRAG_ANIMATION_DURATION : 350;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        mAdapter.itemTouchOnMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int
            actionState, boolean isCurrentlyActive) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public int getBoundingBoxMargin() {
        return super.getBoundingBoxMargin();
    }

    @Override
    public void onChildDraw(final Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int
            actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            // Let the view holder know that this item is being moved or dragged
            ItemTouchHelperViewHolder itemViewHolder = (ItemTouchHelperViewHolder) viewHolder;
            itemViewHolder.onItemSelected(context);
        }

        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.1f;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.9f;
    }
}

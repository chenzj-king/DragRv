package com.dreamliner.dragrv.adapter;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dreamliner.dragrv.R;
import com.dreamliner.dragrv.interfaces.CallbackItemTouch;
import com.dreamliner.dragrv.model.Item;
import com.dreamliner.dragrv.util.ItemTouchHelperViewHolder;
import com.dreamliner.rvhelper.adapter.BaseAdapter;
import com.dreamliner.rvhelper.viewholder.BaseViewHolder;

import java.util.Collections;

/**
 * Created by chenzj on 2017/3/20.
 */

public class SortAdapter extends BaseAdapter<Item, SortAdapter.ViewHolder> implements CallbackItemTouch {

    private OnStartDragListener dragStartListener = null;

    public SortAdapter(OnStartDragListener dragStartListener) {
        this.dragStartListener = dragStartListener;
    }

    @Override
    public ViewHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getView(R.layout.item_click_drag, parent));
    }

    @Override
    protected void bindView(final ViewHolder holder, int position) {
        holder.mSortIv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    dragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {
        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                Collections.swap(getData(), i, i + 1);
            }
        } else {
            for (int i = oldPosition; i > newPosition; i--) {
                Collections.swap(getData(), i, i - 1);
            }
        }
        notifyItemMoved(oldPosition, newPosition);
    }

    static class ViewHolder extends BaseViewHolder implements ItemTouchHelperViewHolder {

        ImageView mSortIv;

        public ViewHolder(View itemView) {
            super(itemView);
            mSortIv = (ImageView) itemView.findViewById(R.id.sort_iv);
        }

        @Override
        public void onItemSelected(Context context) {

        }
    }

    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }
}

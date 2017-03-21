package com.dreamliner.dragrv.ui.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.dreamliner.dragrv.adapter.SortAdapter;
import com.dreamliner.dragrv.model.Item;
import com.dreamliner.dragrv.util.ChildViewTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

import static com.dreamliner.dragrv.common.NormalConstant.IMAGES;
import static com.dreamliner.dragrv.common.NormalConstant.NAMES;

/**
 * Created by chenzj on 2017/3/20.
 */

public class ClickDragActivity extends BaseActivity implements SortAdapter.OnStartDragListener {

    private SortAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected void initView() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < NAMES.length; i++) {
            itemList.add(new Item(IMAGES[i], NAMES[i], ""));
        }
        mAdapter = new SortAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper.Callback callback = new ChildViewTouchHelperCallback(mAdapter, this);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        mAdapter.update(itemList);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}

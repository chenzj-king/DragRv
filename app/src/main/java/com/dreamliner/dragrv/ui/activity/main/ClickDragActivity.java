package com.dreamliner.dragrv.ui.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dreamliner.dragrv.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzj on 2017/3/20.
 */

public class ClickDragActivity extends BaseActivity {

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected void initView() {
        List<Item> itemList = new ArrayList<>();
    }
}

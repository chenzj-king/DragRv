package com.dreamliner.dragrv.ui.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by chenzj on 2017/3/20.
 */

public class LinearLayoutActivity extends BaseActivity {

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected void initView() {
        initDefaultDrag();
    }
}
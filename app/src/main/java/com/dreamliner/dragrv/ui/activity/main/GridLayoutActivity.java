package com.dreamliner.dragrv.ui.activity.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by chenzj on 2017/3/20.
 */

public class GridLayoutActivity extends BaseActivity {

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(this, 3);
    }

    @Override
    protected void initView() {
        initDefaultDrag();
    }
}

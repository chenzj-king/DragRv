package com.dreamliner.dragrv.ui.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.dreamliner.dragrv.R;
import com.dreamliner.dragrv.adapter.PicAdapter;
import com.dreamliner.dragrv.interfaces.CallbackItemTouch;
import com.dreamliner.dragrv.model.Item;
import com.dreamliner.dragrv.util.CustomItHelperCallback;

import java.util.Collections;

import static com.dreamliner.dragrv.common.NormalConstant.IMAGES;
import static com.dreamliner.dragrv.common.NormalConstant.NAMES;

/**
 * Created by chenzj on 2017/3/20.
 */

public abstract class BaseActivity extends AppCompatActivity implements CallbackItemTouch {

    private RecyclerView mRecyclerView;
    private PicAdapter mPicAdapter;

    private String textDescription = "Subtitle description,lorem ipsum text generic etc";

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(getLayoutManager());
        initView();
    }

    protected void initDefaultDrag() {
        mPicAdapter = new PicAdapter();
        for (int i = 0; i < NAMES.length; i++) {
            mPicAdapter.add(new Item(IMAGES[i], NAMES[i], textDescription));
        }
        mRecyclerView.setAdapter(mPicAdapter);
        ItemTouchHelper.Callback callback = new CustomItHelperCallback(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {
        Collections.swap(mPicAdapter.getData(), oldPosition, newPosition);
        mPicAdapter.notifyItemMoved(oldPosition, newPosition);
    }
}

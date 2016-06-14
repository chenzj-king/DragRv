package com.dreamliner.dragrv.ui.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.dreamliner.dragrv.R;
import com.dreamliner.dragrv.adapter.PicAdapter;
import com.dreamliner.dragrv.interfaces.CallbackItemTouch;
import com.dreamliner.dragrv.model.Item;
import com.dreamliner.dragrv.util.CustomItHelperCallback;

import java.util.Collections;

/**
 * @author chenzj
 * @Title: MainActivity
 * @Description: 类的描述 - 主界面
 * @date 2016/6/14 09:52
 * @email admin@chenzhongjin.cn
 */
public class MainActivity extends AppCompatActivity implements CallbackItemTouch {

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView; // RecyclerView
    private PicAdapter mPicAdapter; //The Adapter for RecyclerVIew

    // Array images
    private int images[] = new int[]{
            R.drawable.android,
            R.drawable.batman,
            R.drawable.deadpool,
            R.drawable.gambit,
            R.drawable.hulk,
            R.drawable.mario,
            R.drawable.wolverine,
            R.drawable.daredevil
    };

    // Array names
    private String names[] = new String[]{
            "Android",
            "Batman",
            "DeadPool",
            "Gambit",
            "Hulk",
            "Mario",
            "Wolverine",
            "Daredevil"
    };

    // Description text
    private String textDescription = "Subtitle description,lorem ipsum text generic etc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initRecyclerview(); //call method
    }

    /**
     * Add data to the List
     */
    private void initRecyclerview() {

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set LayoutManager in the RecyclerView
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mPicAdapter = new PicAdapter(); // Create Instance of PicAdapter
        // Adds data to List of Objects Item
        for (int i = 0; i < names.length; i++) {
            mPicAdapter.add(new Item(images[i], names[i], textDescription));
        }

        mRecyclerView.setAdapter(mPicAdapter); // Set Adapter for RecyclerView
        ItemTouchHelper.Callback callback = new CustomItHelperCallback(this);// create CustomItHelperCallback
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback); // Create ItemTouchHelper and pass with parameter the

        touchHelper.attachToRecyclerView(mRecyclerView); // Attach ItemTouchHelper to RecyclerView
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {

        Collections.swap(mPicAdapter.getData(), oldPosition, newPosition); // change position
        mPicAdapter.notifyItemMoved(oldPosition, newPosition); //notifies changes in adapter, in this case use the
        // notifyItemMoved
    }
}

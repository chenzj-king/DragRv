package com.dreamliner.dragrv.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dreamliner.dragrv.R;

/**
 * @author chenzj
 * @Title: MainActivity
 * @Description: 类的描述 - 主界面
 * @date 2016/6/14 09:52
 * @email admin@chenzhongjin.cn
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.linear_layout_tv).setOnClickListener(this);
        findViewById(R.id.grid_layout_tv).setOnClickListener(this);
        findViewById(R.id.click_drag_tv).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_tv:
                goNewAct(LinearLayoutActivity.class);
                break;
            case R.id.grid_layout_tv:
                goNewAct(GridLayoutActivity.class);
                break;
            case R.id.click_drag_tv:
                goNewAct(ClickDragActivity.class);
                break;
        }
    }

    private void goNewAct(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}

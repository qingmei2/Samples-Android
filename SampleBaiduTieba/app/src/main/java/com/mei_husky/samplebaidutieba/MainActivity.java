package com.mei_husky.samplebaidutieba;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mei_husky.samplebaidutieba.Tieba.ItemTiebaDivider;
import com.mei_husky.samplebaidutieba.Tieba.MyTiebaAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCvSortLevel;
    private TextView mTvLayout;
    private CardView mCvLayout;
    private LinearLayout mLlHide;
    private RecyclerView mRecyclerView;
    private LinearLayout mActivityMain;

    private boolean TYPE_MANAGER_GRID = true;
    private MyTiebaAdapter adapter;
    private ItemTouchHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setHideBarVisible(IsHideBarVisible);
        initData();
        initRecyclerView();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("贴吧序列号：" + i);
        }
    }

    private ArrayList<String> list = new ArrayList<>();

    //默认等级排序和视图可视
    private boolean IsHideBarVisible = true;

    /**
     * 设置recyclerView编辑状态下的头布局是否可视
     *
     * @param IsHideBarVisible
     */
    private void setHideBarVisible(boolean IsHideBarVisible) {
        mTvLayout.setText(TYPE_MANAGER_GRID ? "单列视图" : "双列视图");
        mLlHide.setVisibility(IsHideBarVisible ? View.VISIBLE : View.GONE);
    }

    private void initView() {
        mCvSortLevel = (CardView) findViewById(R.id.cv_sort_level);
        mTvLayout = (TextView) findViewById(R.id.tv_layout);
        mCvLayout = (CardView) findViewById(R.id.cv_layout);
        mLlHide = (LinearLayout) findViewById(R.id.ll_hide);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);

        mCvLayout.setOnClickListener(this);
        mCvSortLevel.setOnClickListener(this);
    }

    /**
     * 配置recyclerview
     */
    private void initRecyclerView() {
        RecyclerView.LayoutManager manager;
        if (TYPE_MANAGER_GRID) {
            //流式布局
            manager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        } else {
            //单列线性布局
            manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
        mRecyclerView.setLayoutManager(manager);  //配置manager
        //创建adapter并设置
        if (adapter == null) {
            adapter = new MyTiebaAdapter(this, list);
        }
        mRecyclerView.setAdapter(adapter);
        //灰色的分割线
        mRecyclerView.addItemDecoration(new ItemTiebaDivider().setDividerWith(1).setDividerColor(Color.GRAY));
        //绑定ItemTouchHelper
        if (helper != null) {
            helper.attachToRecyclerView(null);
        }
        helper = new ItemTouchHelper(new MySlideViewTouchHandler(adapter));
        helper.attachToRecyclerView(mRecyclerView);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_layout:
                TYPE_MANAGER_GRID = !TYPE_MANAGER_GRID;
                initRecyclerView();
                mTvLayout.setText(TYPE_MANAGER_GRID ? "单列视图" : "双列视图");
                break;
            case R.id.cv_sort_level:
                Toast.makeText(this, "等级排序", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

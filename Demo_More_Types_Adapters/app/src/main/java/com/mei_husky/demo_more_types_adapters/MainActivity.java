package com.mei_husky.demo_more_types_adapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShow;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mRv = (RecyclerView) findViewById(R.id.rv);

        mBtnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                showData();
                break;
        }
    }


    /**
     * 展示数据列表
     */
    private void showData() {
        initData();
//        showDataNormal();
        showDataByAdapter();
    }

    /**
     * 优雅的展示多类型列表的adapter
     */
    private void showDataByAdapter() {
        MyRecyclerViewAmazAdapter amazAdapter = new MyRecyclerViewAmazAdapter(this, datas);
        mRv.setAdapter(amazAdapter);
        LinearLayoutManager amazManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(amazManager);
    }

    /**
     * 普通方式展示多类型列表
     */
    private void showDataNormal() {
        MyRecyclerViewNormalAdapter normalAdapter = new MyRecyclerViewNormalAdapter(this, datas);
        mRv.setAdapter(normalAdapter);
        LinearLayoutManager normalManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(normalManager);
    }

    public boolean isFirstInitData=true;

    public ArrayList<Integer> datas=new ArrayList<Integer>();

    /**
     * 初始化数据
     */
    private void initData() {
        if(isFirstInitData){
            isFirstInitData=false;
            for(int i=0;i<50;i++){
                datas.add(i);
            }
        }
    }
}

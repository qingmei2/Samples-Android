package com.mei_husky.sample_impression;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.mei_husky.sample_impression.recyclerview.MyRvAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mBtShow;
    private RecyclerView mRvImpressions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        datas.clear();
        datas.add("正直勇敢");
        datas.add("阳光帅小伙");
        datas.add("不明觉厉");
        datas.add("23333333333");
        datas.add("牛牛牛~~~");
        datas.add("挺喜欢你的");
        datas.add("爱你一万年");
        datas.add("超级大闷骚");
        datas.add("代码狂魔");
        datas.add("始作俑者");
        datas.add("弹幕大神");
        datas.add("你行你上啊");
    }


    private void initView() {
        mBtShow = (CardView) findViewById(R.id.bt_show);
        mRvImpressions = (RecyclerView) findViewById(R.id.rv_impressions);
        mBtShow.setOnClickListener(this);

    }
    private MyRvAdapter adapter;

    public ArrayList<String> datas=new ArrayList<>();

    private void initRecyclerView() {
        mRvImpressions.setAdapter(adapter==null?new MyRvAdapter(this,datas):adapter);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRvImpressions.setLayoutManager(manager);



    }

    @Override
    public void onClick(View view) {
        initRecyclerView();
    }
}

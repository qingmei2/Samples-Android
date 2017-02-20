package com.mei_husky.demo_more_types_adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mei_husky.demo_more_types_adapters.factory.ItemFactoryList;
import com.mei_husky.demo_more_types_adapters.factory.ItemInterface;
import com.mei_husky.demo_more_types_adapters.factory.ItemType1;
import com.mei_husky.demo_more_types_adapters.factory.ItemType2;
import com.mei_husky.demo_more_types_adapters.factory.ItemType3;
import com.mei_husky.demo_more_types_adapters.holder.BaseAmazViewHolder;

import java.util.ArrayList;

/**
 * Created by QingMei on 2017/2/20 16:58
 * email:mei_husky@qq.com
 * desc:Used to  优雅的实现多类型列表的Adapter
 */
public class MyRecyclerViewAmazAdapter extends RecyclerView.Adapter<BaseAmazViewHolder> {

    private Context ctx;
    private ArrayList<Integer> datas;
    private ArrayList<ItemInterface> datas2=new ArrayList<ItemInterface>();
    private final ItemFactoryList factory;

    public MyRecyclerViewAmazAdapter(Context ctx, ArrayList<Integer> datas){
        this.ctx = ctx;
        this.datas = datas;
        factory = new ItemFactoryList();
        initBeans();
    }

    private void initBeans() {
        for(int i=0;i<datas.size();i++){
            if(i%3==0){
                datas2.add(new ItemType1(i));
            }else if(i%3==1){
                datas2.add(new ItemType2(i));
            }else{
                datas2.add(new ItemType3(i));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return datas2.get(position).type(factory);
    }

    @Override
    public BaseAmazViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(viewType, parent, false);
        return factory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(BaseAmazViewHolder holder, int position) {
        holder.setUpView(datas2.get(position),position,this);
    }

    @Override
    public int getItemCount() {
        return datas2.size();
    }

}

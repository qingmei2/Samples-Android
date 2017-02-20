package com.mei_husky.demo_more_types_adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by QingMei on 2017/2/20 16:23
 * email:mei_husky@qq.com
 * desc:Used to
 */
public class MyRecyclerViewNormalAdapter extends RecyclerView.Adapter {

    private Context ctx;
    private ArrayList<Integer> datas;

    public MyRecyclerViewNormalAdapter(Context ctx, ArrayList<Integer> datas) {
        this.ctx = ctx;
        this.datas = datas;
    }

    private final int ITEM_TYPE_1 = 1;
    private final int ITEM_TYPE_2 = 2;
    private final int ITEM_TYPE_3 = 3;

    @Override
    public int getItemViewType(int position) {
        if (datas.get(position) % 3 == 0) {
            return ITEM_TYPE_1;
        } else if (datas.get(position) % 3 == 1) {
            return ITEM_TYPE_2;
        } else {
            return ITEM_TYPE_3;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType== ITEM_TYPE_1){
            return new MyViewHolder1(LayoutInflater.from(ctx).inflate(R.layout.listitem_type_1,parent,false));
        }else if(viewType== ITEM_TYPE_2){
            return new MyViewHolder2(LayoutInflater.from(ctx).inflate(R.layout.listitem_type_2,parent,false));
        }else {
            return new MyViewHolder3(LayoutInflater.from(ctx).inflate(R.layout.listitem_type_3,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder1 ){
            ((MyViewHolder1) holder).tv.setText("content"+position);
            ((MyViewHolder1) holder).tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx,"MyViewHolder1",Toast.LENGTH_SHORT).show();
                }
            });
        }else if(holder instanceof MyViewHolder2){
            ((MyViewHolder2) holder).tv.setText("content"+position);
            ((MyViewHolder2) holder).tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx,"MyViewHolder2",Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            ((MyViewHolder3) holder).tv.setText("content"+position);
            ((MyViewHolder3) holder).tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx,"MyViewHolder3",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * item_type_1所对应的viewHolder
     */
    class MyViewHolder1 extends RecyclerView.ViewHolder {

        public MyViewHolder1(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_content1);
        }
        public TextView tv;
    }

    /**
     * item_type_2所对应的viewHolder
     */
    class MyViewHolder2 extends RecyclerView.ViewHolder {

        public MyViewHolder2(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_content2);
        }
        public TextView tv;
    }

    /**
     * item_type_3所对应的viewHolder
     */
    class MyViewHolder3 extends RecyclerView.ViewHolder {

        public MyViewHolder3(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_content3);
        }
        public TextView tv;
    }
}

package com.mei_husky.sample_impression.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mei_husky.sample_impression.MyUtils;
import com.mei_husky.sample_impression.R;
import com.mei_husky.sample_impression.view.ImpressionView;

import java.util.ArrayList;

/**
 * Created by QingMei on 2017/1/15 13:34
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<String> datas;

    private int[] bgs=new int[]{
            Color.parseColor("#ccffff"),
            Color.parseColor("#ffcc99"),
            Color.parseColor("#ff6666"),
            Color.parseColor("#ccffff"),
            Color.parseColor("#ccff99"),
            Color.parseColor("#cccccc"),
            Color.parseColor("#99cc99"),
            Color.parseColor("#ff9966"),
            Color.parseColor("#99cccc"),
    };



    public MyRvAdapter(Context ctx, ArrayList<String> datas) {
        this.ctx = ctx;
        this.datas = datas;
    }


    @Override
    public MyRvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(ctx, R.layout.item_rv,null));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.iv.setBgText(datas.get(position));
        holder.iv.setBgColor(bgs[position%bgs.length]);
        holder.iv.setOnCheckCancleButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datas.remove(holder.getLayoutPosition());
                notifyItemRemoved(holder.getLayoutPosition());
//                notifyItemRangeChanged(holder.getLayoutPosition(),1);
//                notifyDataSetChanged();
                MyUtils.LogI("layoutposition=="+holder.getLayoutPosition());
                MyUtils.LogI("position=="+position);
                MyUtils.LogI("datas数据源size=="+datas.size());
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImpressionView) itemView.findViewById(R.id.item_rv);
        }

        public ImpressionView iv;
    }
}

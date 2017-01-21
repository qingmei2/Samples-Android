package com.mei_husky.samplebaidutieba.Tieba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mei_husky.samplebaidutieba.MySlideViewTouchHandler;
import com.mei_husky.samplebaidutieba.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by QingMei on 2017/1/21 14:48
 * email:mei_husky@qq.com
 * desc:Used to  贴吧界面的adapter
 */

public class MyTiebaAdapter extends MySlideViewTouchHandler.ItemTouchAdapter{

    private Context ctx;
    private ArrayList<String> list;

    public MyTiebaAdapter(Context ctx, ArrayList<String> list) {
        this.ctx = ctx;
        this.list = list;
    }

    /**
     * item发生移动的回调，这时ui已经变化了，我们需要做的就是更新数据源
     * @param fromPosition
     * @param toPosition
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);  //集合内元素交换
    }

    /**
     * item滑动移除的回调，同上我们只需要更新数据源就行了
     * @param position
     */
    @Override
    public void onItemRemove(int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_tieba_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).tvTitle.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class  MyViewHolder  extends  RecyclerView.ViewHolder{

        public ImageView ivCancle;
        public TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivCancle = (ImageView) itemView.findViewById(R.id.iv_cancel);
            tvTitle=(TextView)itemView.findViewById(R.id.tv_title);
        }
    }
}

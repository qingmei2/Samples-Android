package com.mei_husky.demo_more_types_adapters.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.mei_husky.demo_more_types_adapters.MyRecyclerViewAmazAdapter;

/**
 * Created by QingMei on 2017/2/20 17:29
 * email:mei_husky@qq.com
 * desc:Used to
 */

public abstract class BaseAmazViewHolder<T> extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    private View mItemView;

    public BaseAmazViewHolder(View itemView) {
        super(itemView);
        views=new SparseArray<>();
        this.mItemView=itemView;
    }

    public View getView(int resID){
        View view=views.get(resID);
        if (view == null) {
            view = mItemView.findViewById(resID);
            views.put(resID,view);
        }

        return view;
    }

    public abstract void setUpView(T model, int position, MyRecyclerViewAmazAdapter adapter);
}

package com.mei_husky.demo_more_types_adapters.factory;

import android.view.View;

import com.mei_husky.demo_more_types_adapters.holder.BaseAmazViewHolder;

/**
 * Created by QingMei on 2017/2/20 17:04
 * email:mei_husky@qq.com
 * desc:Used to
 */
public interface ItemFactory {

    int type(ItemType1 type1);

    int type(ItemType2 type2);

    int type(ItemType3 type3);

    BaseAmazViewHolder createViewHolder(int type, View itemView);
}


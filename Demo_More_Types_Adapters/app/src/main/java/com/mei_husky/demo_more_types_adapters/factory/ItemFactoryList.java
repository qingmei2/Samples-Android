package com.mei_husky.demo_more_types_adapters.factory;

import android.view.View;

import com.mei_husky.demo_more_types_adapters.R;
import com.mei_husky.demo_more_types_adapters.holder.BaseAmazViewHolder;
import com.mei_husky.demo_more_types_adapters.holder.ItemHolder1;
import com.mei_husky.demo_more_types_adapters.holder.ItemHolder2;
import com.mei_husky.demo_more_types_adapters.holder.ItemHolder3;

/**
 * Created by QingMei on 2017/2/20 17:08
 * email:mei_husky@qq.com
 * desc:Used to
 */
public class ItemFactoryList implements ItemFactory {

    private final int item_type_1= R.layout.listitem_type_1;
    private final int item_type_2= R.layout.listitem_type_2;
    private final int item_type_3= R.layout.listitem_type_3;

    @Override
    public int type(ItemType1 type1) {
        return item_type_1;
    }

    @Override
    public int type(ItemType2 type2) {
        return item_type_2;
    }

    @Override
    public int type(ItemType3 type3) {
        return item_type_3;
    }

    @Override
    public BaseAmazViewHolder createViewHolder(int type, View itemView) {
        if(item_type_1 == type){
            return new ItemHolder1(itemView);
        }else if (item_type_2 == type){
            return new ItemHolder2(itemView);
        }else if (item_type_3 == type){
            return new ItemHolder3(itemView);
        }
        return null;
    }
}

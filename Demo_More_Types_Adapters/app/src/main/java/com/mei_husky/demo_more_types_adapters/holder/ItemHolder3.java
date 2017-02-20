package com.mei_husky.demo_more_types_adapters.holder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mei_husky.demo_more_types_adapters.MyRecyclerViewAmazAdapter;
import com.mei_husky.demo_more_types_adapters.R;
import com.mei_husky.demo_more_types_adapters.factory.ItemType3;

/**
 * Created by QingMei on 2017/2/20 17:35
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class ItemHolder3 extends BaseAmazViewHolder {

    public ItemHolder3(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Object model, int position, MyRecyclerViewAmazAdapter adapter) {
        ItemType3 type3 = (ItemType3) model;
        final TextView tv = (TextView) getView(R.id.tv_content3);
        tv.setText("content"+type3.values);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(tv.getContext(),"ItemHolder3",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

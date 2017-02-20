package com.mei_husky.demo_more_types_adapters.holder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mei_husky.demo_more_types_adapters.MyRecyclerViewAmazAdapter;
import com.mei_husky.demo_more_types_adapters.R;
import com.mei_husky.demo_more_types_adapters.factory.ItemType1;

/**
 * Created by QingMei on 2017/2/20 17:35
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class ItemHolder1 extends BaseAmazViewHolder {

    public ItemHolder1(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Object model, int position, final MyRecyclerViewAmazAdapter adapter) {
        ItemType1 type1 = (ItemType1) model;
        final TextView tv = (TextView) getView(R.id.tv_content1);
        tv.setText("content"+type1.values);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(tv.getContext(),"ItemHolder1",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

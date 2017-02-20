package com.mei_husky.demo_more_types_adapters.holder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mei_husky.demo_more_types_adapters.MyRecyclerViewAmazAdapter;
import com.mei_husky.demo_more_types_adapters.R;
import com.mei_husky.demo_more_types_adapters.factory.ItemType2;

/**
 * Created by QingMei on 2017/2/20 17:35
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class ItemHolder2 extends BaseAmazViewHolder {

    public ItemHolder2(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Object model, int position, MyRecyclerViewAmazAdapter adapter) {
        ItemType2 type2 = (ItemType2) model;
        final TextView tv = (TextView) getView(R.id.tv_content2);
        tv.setText("content"+type2.values);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(tv.getContext(),"ItemHolder2",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.mei_husky.demo_more_types_adapters.factory;

/**
 * Created by QingMei on 2017/2/20 17:07
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class ItemType2 implements ItemInterface {
    public int values;

    public ItemType2(int values) {
        this.values = values;
    }
    @Override
    public int type(ItemFactory factory) {
        return factory.type(this);
    }
}

package com.qingmei2.sampleproxy.static_proxy;

/**
 * Created by QingMei on 2017/10/25.
 * desc:
 */

public class RealSubject implements Subject {

    @Override
    public void enjoyMusic() {
        System.out.println("enjoyMusic");
    }

    @Override
    public void enjoyFood() {
        System.out.println("enjoyFood");
    }

    @Override
    public void enjoyBeer() {
        System.out.println("enjoyBeer");
    }
}

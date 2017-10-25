package com.qingmei2.sampleproxy.static_proxy;

/**
 * Created by QingMei on 2017/10/25.
 * desc:
 */

public class SubjectProxy implements Subject {

    private Subject subject = new RealSubject();

    @Override
    public void enjoyMusic() {
        subject.enjoyMusic();
    }

    @Override
    public void enjoyFood() {
        subject.enjoyFood();
    }

    @Override
    public void enjoyBeer() {
        subject.enjoyBeer();
    }
}

package com.qingmei2.sampleproxy;

import com.qingmei2.sampleproxy.dynamic_proxy.DynamicProxy;
import com.qingmei2.sampleproxy.dynamic_proxy.RealSubject;
import com.qingmei2.sampleproxy.dynamic_proxy.Subject;
import com.qingmei2.sampleproxy.static_proxy.SubjectProxy;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ProxyTest {

    @Test
    public void staticProxy() throws Exception {
        SubjectProxy proxy = new SubjectProxy();

        proxy.enjoyMusic();
        proxy.enjoyFood();
        proxy.enjoyBeer();
    }

    @Test
    public void dynamicProxy() throws Exception {
        RealSubject realSubject = new RealSubject();
        Subject proxy = (Subject) new DynamicProxy(realSubject).bind();

        System.out.println(proxy.getClass().getName());

        proxy.enjoyMusic();
        proxy.enjoyFood();
        proxy.enjoyBeer();
    }
}
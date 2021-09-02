package com.zys.proxy;

import java.lang.reflect.Proxy;

public class Consumer {


    public static void main(String[] args) {
        Commissioned commissioned = new CommissionedImpl();

        Commissioned staticCommissioned = new StaticProxy(commissioned);
        staticCommissioned.study();

        Commissioned dynamicCommissioned = (Commissioned) Proxy.newProxyInstance(Commissioned.class.getClassLoader(), new Class[]{Commissioned.class},
                new DynamicProxyHandler(commissioned));
        dynamicCommissioned.study();
    }

}

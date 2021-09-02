package com.zys.proxy;

/**
 * 静态代理类
 */
public class StaticProxy implements Commissioned {

    private Commissioned commissioned;

    public StaticProxy(final Commissioned commissioned) {
        this.commissioned = commissioned;
    }

    @Override
    public void study() {
        System.out.println("先来一盘紧张刺激的炉石");
        commissioned.study();
        System.out.println("刷会儿B站放松一下");
    }
}

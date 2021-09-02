package com.zys.proxy;

/**
 * 委托类
 *
 */
public class CommissionedImpl implements Commissioned {

    @Override
    public void study() {
        System.out.println("学习!");
    }
}

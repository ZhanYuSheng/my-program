package com.zys.design.singleton;

/**
 * 单例模式-饿汉式
 *
 */
public class Hungry {

    public static Hungry instance = new Hungry();

    private Hungry(){
    }

    public static Hungry getInstance(){
        return instance;
    }

}

package com.zys.design.singleton;

/**
 * 单例模式-懒汉式线程不安全
 *
 */
public class Lazy {

    public static Lazy instance = null;

    private Lazy(){
    }

    public static Lazy getInstance(){
        if (instance == null){
            instance = new Lazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Lazy.getInstance());
            });
            thread.start();
        }
    }
}

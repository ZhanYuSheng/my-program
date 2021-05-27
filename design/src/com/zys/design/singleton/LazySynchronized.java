package com.zys.design.singleton;

/**
 * 单例模式-懒汉式线程安全
 *
 */
public class LazySynchronized {

    public static LazySynchronized instance = null;

    private LazySynchronized(){
    }

    public static LazySynchronized getInstance(){
        if (instance == null){
            synchronized (LazySynchronized.class){
                if (instance == null){
                    instance = new LazySynchronized();
                }
            }
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
                System.out.println(LazySynchronized.getInstance());
            });
            thread.start();
        }
    }
}

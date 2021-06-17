package com.zys.threadLocal;

public class threadLocalDemo {

    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            longThreadLocal.set(Thread.currentThread().getId());
            stringThreadLocal.set(Thread.currentThread().getName());
            System.out.println(longThreadLocal.get());
            System.out.println(stringThreadLocal.get());
        });
        thread.start();
        Thread.sleep(1);
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
        System.out.println(longThreadLocal.get());
        System.out.println(stringThreadLocal.get());
    }

}

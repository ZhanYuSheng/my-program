package com.zys.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程池容量: " + threadPoolExecutor.getPoolSize());
        System.out.println("线程池存活线程数量: " + threadPoolExecutor.getActiveCount());
        System.out.println("线程池核心线程: " + threadPoolExecutor.getCorePoolSize());
        System.out.println("================");
        for (int i = 0; i < 11; i++){
            threadPoolExecutor.execute(new Worker());
        }
        System.out.println("==============for循环结束============");
        while (true){
            Thread.sleep(1000);
            System.out.println("线程池容量: " + threadPoolExecutor.getPoolSize());
            System.out.println("线程池存活线程数量: " + threadPoolExecutor.getActiveCount());
            System.out.println("线程池核心线程: " + threadPoolExecutor.getCorePoolSize());
            System.out.println("等待队列中的任务数: " + threadPoolExecutor.getQueue().size());
            System.out.println("================");
        }
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("工人" + threadName + "开始工作" +
                    "线程池容量: " + threadPoolExecutor.getPoolSize() +
                    " | 线程池存活线程数量: " + threadPoolExecutor.getActiveCount() +
                    " | 线程池核心线程: " + threadPoolExecutor.getCorePoolSize() +
                    " | 等待队列中的任务数: " + threadPoolExecutor.getQueue().size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("工人" + threadName + "工作结束");
        }
    }

}

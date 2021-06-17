package com.zys.cacheline;

/**
 * Padding类的p1~p7为7个long类型的变量，占56字节，T中的x占用8字节，一共64字节。
 * 所以arr[0]与arr[1]不在一个缓存行中。
 * t1修改arr[0]时不会通知t2重新读取缓存行，使得效率提高
 *
 */
public class CacheLinePadding02 {

    private static class Padding{
        public volatile long p1,p2,p3,p4,p5,p6,p7;
    }

    private static class T extends Padding{
        public volatile long x = 0L;
    }

    private static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_1000L; i++){
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_1000L; i++){
                arr[1].x = i;
            }
        });
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 100_1000L);
    }
}

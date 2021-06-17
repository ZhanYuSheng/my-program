package com.zys.cacheline;

/**
 * CPU中的计算单元与寄存器每次都会读取一个缓存行(cache_line，64字节)的数据。
 * x为long类型占用8字节，所以arr[0]与arr[1]在同一缓存行
 * 负责t1的计算单元与寄存器在修改arr[0].x时，会通知同样在操作该缓存行的t2(计算单元与寄存器)重新读取数据，同理t2也会通知t1重新读取数据。
 *
 */
public class CacheLinePadding01 {

    private static class T {
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

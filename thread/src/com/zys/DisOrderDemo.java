package com.zys;

/**
 * 演示指令重排问题
 * 若正确执行，则不可能出现x==0 && y==0的情况。
 * 当发生指令重排，使线程中的代码乱序，则有可能出现
 *      x=b;
 *      b=1;
 *      y=a;
 *      a=1;
 * 这样的执行顺序
 */
public class DisOrderDemo {

    private static int a, b, x, y;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("第" + i + "次(" + x + "," + y + ")");
            if (x == 0 && y == 0) {
                break;
            }
        }
    }

}

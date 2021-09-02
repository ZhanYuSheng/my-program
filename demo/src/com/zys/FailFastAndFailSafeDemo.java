package com.zys;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用来演示快速失败(fail-fast)和安全失败(fail-safe)
 * 差别在于ConcurrentModificationException
 *
 * 快速失败: 当你在迭代一个集合的时候，如果有另一个线程正在修改你正在访问的那个集合时，就会抛出一个ConcurrentModificationException。
 * 在java.util包下的都是快速失败。
 * 安全失败: 你在迭代的时候会去底层集合做一个拷贝，所以你在修改上层集合的时候是不会受影响的，不会抛出ConcurrentModificationException。
 * 在java.util.concurrent包下的诠释安全失败
 * (以上摘自芋道源码)
 *
 * 当collection为ArrayList时，thread2在迭代的同时thread1修改了collection，就会抛出异常(下面代码可能会出现thread1修改之前thread2已经执
 * 行完毕的情况，此时不会产生异常)。
 * 当collection为ConcurrentLinkedQueue时则任何时候都不会产生异常。但thread2可能读到thread1已删除的元素。
 */
public class FailFastAndFailSafeDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);
        int count = 0;
        while (true) {
            count++;
            List<Integer> collection = new CopyOnWriteArrayList<>();
//            List<Integer> collection = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                collection.add(i);
            }
            Thread thread2 = new Thread(() -> {
                try {
                    Iterator<Integer> iterator = collection.iterator();
//                    System.out.println(Thread.currentThread().getName() + "开始遍历list");
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
//                        System.out.println(Thread.currentThread().getName() + ".next = " + next);
                        if (next.equals(8)) {
                            flag.set(false);
                        }
                    }
//                    System.out.println(Thread.currentThread().getName() + "遍历list结束");
                } catch (Exception e) {
                    System.out.println("捕获到异常: " + e);
                }
            });
            Thread thread1 = new Thread(() -> {
                Iterator<Integer> iterator = collection.iterator();
//                System.out.println(Thread.currentThread().getName() + "开始遍历list");
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
//                    System.out.println(Thread.currentThread().getName() + ".next = " + next);
                    if (next.equals(8)) {
                        iterator.remove();
//                        System.out.println(Thread.currentThread().getName() + "->remove()");
                    }
                }
//                System.out.println(Thread.currentThread().getName() + "遍历list结束");
            });

            thread1.start();
            thread2.start();
            Thread.sleep(66);
            if (flag.get()) {
                System.out.println("遍历了" + count + "次");
                break;
            }
            flag.set(true);
        }
    }

}

package com.zys.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            for (int i = 0; i <10000000; i++){
//                a.increaseSyn();
//                a.increase();
//                a.increaseAtomic();
                a.increaseCas();
            }
        });
        t1.start();
        for (int i = 0; i <10000000; i++){
//            a.increaseSyn();
//            a.increase();
//            a.increaseAtomic();
            a.increaseCas();
        }
        t1.join();
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start));
//        System.out.println("num: " + a.getNum());
//        System.out.println("numSyn: " + a.getNumSyn());
//        System.out.println("numAtomic: " + a.getNumAtomic());
        System.out.println("numCas: " + a.getNumCas());
    }


}

class A {

    private int num;
    private int numSyn;
    private AtomicInteger numAtomic = new AtomicInteger();
    private AtomicInteger numCas = new AtomicInteger();


    public int getNumSyn() {
        return numSyn;
    }

    public AtomicInteger getNumAtomic() {
        return numAtomic;
    }

    public int getNum() {
        return num;
    }

    public AtomicInteger getNumCas() {
        return numCas;
    }

    public void increase(){
        num++;
    }

    public synchronized void increaseSyn(){
        numSyn++;
    }

    public void increaseAtomic(){
        numAtomic.incrementAndGet();
    }

    public void increaseCas(){
        while (true){
            int oldNum = numCas.get();
            int newNum = oldNum++;
            if (numCas.compareAndSet(oldNum, newNum)){
                break;
            }
        }
    }
}

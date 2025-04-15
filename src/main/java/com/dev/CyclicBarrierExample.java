package com.dev;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author haoze
 * @create 2025/4/9 10:42
 * @description
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        int threadCount = 3;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount,()->{
            System.out.println("all thread is arriving");
        });
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+":arrive barrier");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}

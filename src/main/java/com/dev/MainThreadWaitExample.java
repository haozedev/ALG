package com.dev;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haoze
 * @create 2025/4/9 14:27
 * @description
 */
public class MainThreadWaitExample {
    public static void main(String[] args) {
        int count = 3;
        new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "execute task");
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Worker-"+i).start();
        }
        try {
            latch.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("all task finished");
    }
}

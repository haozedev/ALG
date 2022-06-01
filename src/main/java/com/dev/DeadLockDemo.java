package com.dev;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description 死锁
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/1
 * @Version TODO
 * @History TODO
 **/

class HoldLockThread implements Runnable {

    private final String lockA;
    private final String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + "\t尝试获得" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + "\t尝试获得" + lockA);
            }
        }

    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
     String lockA = "lockA";
     String lockB = "lockB";

     new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();

     new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();
    }
}

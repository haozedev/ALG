package com.juc.locks;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class LockUpgradeExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个对象用于同步
        Object obj = new Object();
        System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

        // 创建并启动第一个线程，尝试获取偏向锁
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

                System.out.println("Thread 1 acquired lock.");
                try {
                    // 模拟线程工作
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

        // 等待第一个线程获取锁
        Thread.sleep(1000);

        // 创建并启动第二个线程，尝试获取锁，触发锁升级
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

                System.out.println("Thread 2 acquired lock.");
            }
        });
        System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

        t2.start();

        // 等待两个线程结束
        t1.join();
        t2.join();

        System.out.println("Lock upgrade example finished.");
    }
}

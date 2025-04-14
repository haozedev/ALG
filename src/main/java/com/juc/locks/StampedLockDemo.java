package com.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author haoze
 * @create 2025/4/14 16:54
 * @description
 */
public class StampedLockDemo {

    static int count = 37;

    static StampedLock stampedLock = new StampedLock();

    public static void write() {
        System.out.println(Thread.currentThread().getName() + "write lock come in");
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName() + "get write lock");

        count += 13;
        stampedLock.unlockWrite(stamp);
        System.out.println(Thread.currentThread().getName() + "完成写入");
    }

    public static void read() {
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName() + "come in read lock,4s continue...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            int result = count;
            System.out.println(Thread.currentThread().getName() + "完成读取" + result);
            System.out.println("under read lock thread,write lock can not change count");
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public static void tryRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int result = count;
        System.out.println("4秒前 stampedLock.validate(true no change,false change) " + stampedLock.validate(stamp));

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在读取" + i + "秒" + "stampedLock.validate(true no change,false change)" + stampedLock.validate(stamp));
        }
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            System.out.println("有人修改过---有写操作");
            try {
                System.out.println("从乐观锁升级为悲观锁");
                result = count;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        System.out.println(Thread.currentThread().getName() + "完成读取" + result);
    }

    public static void main(String[] args) {

        new Thread(() -> {
            read();
        }, "read").start();
        new Thread(() -> {
            write();
        }, "write").start();
//        new Thread(() -> {
//            tryRead();
//        }, "tryRead").start();

    }
}

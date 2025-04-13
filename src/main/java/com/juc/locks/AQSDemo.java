package com.juc.locks;

import lombok.val;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            reentrantLock.lock();
            try {
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"come in ...");
            } finally {
                reentrantLock.unlock();
            }
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"come in ...");
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"get lock ...");
            } finally {
                reentrantLock.unlock();
            }
        }, "B").start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"come in ...");
            } finally {
                reentrantLock.unlock();
            }
        }, "C").start();
    }
}

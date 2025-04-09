package com.dev;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haoze
 * @create 2025/4/9 9:32
 * @description
 */
public class ConditionTest {
    private final static Lock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("producer : producing");
                Thread.sleep(200);
                System.out.println("producer : finished");
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("consumer : accept");
                condition.await();
                System.out.println("consumer : finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        consumer.start();
        producer.start();
    }

}

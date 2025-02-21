package com.api;

/**
 * volatile 关键字实现线程交替加减
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class DemoClass{
    //通信对象:0--打印 A 1---打印 B 2----打印 C
    private int number = 0;
    //声明锁
    private Lock lock = new ReentrantLock();
    //声明钥匙 A
    private Condition conditionA = lock.newCondition();
    //声明钥匙 B
    private Condition conditionB = lock.newCondition();
    //声明钥匙 C
    private Condition conditionC = lock.newCondition();
    /**
     * A 打印 5 次
     */
    public void printA(int j){
        try {
            lock.lock();
            while (number != 0){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出 A,第" + j + "轮开始");
                    //输出 5 次 A
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
            }
            //开始打印 B
            number = 1;
            //唤醒 B
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     * B 打印 10 次
     */
    public void printB(int j){
        try {
            lock.lock();
            while (number != 1){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出 B,第" + j + "轮开始");
                    //输出 10 次 B
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }
            //开始打印 C
            number = 2;
            //唤醒 C
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     * C 打印 15 次
     */
    public void printC(int j){
        try {
            lock.lock();
            while (number != 2){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出 C,第" + j + "轮开始");
                    //输出 15 次 C
            for (int i = 0; i < 15; i++) {
                System.out.println("C");
            }
            System.out.println("-----------------------------------------");
            //开始打印 A
            number = 0;
            //唤醒 A
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        DemoClass demoClass = new DemoClass();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                demoClass.printA(i);
            }
        }, "A 线程").start();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                demoClass.printB(i);
            }
        }, "B 线程").start();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                demoClass.printC(i);
            }
        }, "C 线程").start();
    }
}

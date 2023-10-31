package com.juc.locks;

/**
 * @ClassName ReEntryLockDemo
 * @Author haoZe
 * @Date 2023/10/31
 **/
public class ReEntryLockDemo {
    public static void main(String[] args) {

        ReEntryLockDemo reEntryLockDemo = new ReEntryLockDemo();
        new Thread(()->{
           reEntryLockDemo.m1();
        },"t1").start();
    }

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"\t----come in");
        m2();
        System.out.println(Thread.currentThread().getName()+"\t----end");
    }
    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+"\t----come in");
        m3();
    }
    public synchronized void m3(){
        System.out.println(Thread.currentThread().getName()+"\t----come in");
    }

    private static void reEntryM1(Object object) {
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t----外层调用");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t----中层调用");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t----内层调用");
                    }
                }
            }
        },"t1").start();
    }
}

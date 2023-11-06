package com.juc.interrupt;

/**
 * @author haoze
 * @create 2023/11/6 11:11
 * @description main    false
 *              main	false
 *              ----1
 *              ----2
 *              main	true
 *              main	false
 * Process finished with exit code 0
 */
public class InterruptedDemo4 {
    //测试当前线程是否被中断《检查中断标志)，返回一个boolean并清除中断状态
    // 第二次再调用时中断状态已经被除，将返回一个false。
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
        System.out.println("----1");
        Thread.currentThread().interrupt();//中断标志改为true
        System.out.println("----2");
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());//返回后清0，置为false
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());

        Thread.interrupted();//静态方法
        Thread.currentThread().isInterrupted();//实例方法
    }
}

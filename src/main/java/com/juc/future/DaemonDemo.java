package com.juc.future;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DaemonDemo
 * @Author haoZe
 * @Date 2023/3/20
 **/
public class DaemonDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 开始运行，"+
                    (Thread.currentThread().isDaemon() ? "守护线程":"用户线程"));
            while (true){

            }
        },"t1");
        t1.start();
        t1.setDaemon(true);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t ---end 主线程");
    }

}

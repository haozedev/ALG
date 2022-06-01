package com.dev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyThreadPoolDemo
 * @Description 第四种获得/使用Java多线程的方式--线程池
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/31
 * @Version TODO
 * @History TODO
 **/

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //固定数线程--执行长期稳定的任务
//        ExecutorService threadPool1 = Executors.newFixedThreadPool(1);
//        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool1 = Executors.newCachedThreadPool();
        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {  
            for (int i = 1;i<=10;i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            System.out.println("-------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }


        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}

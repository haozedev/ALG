package com.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureAPI2Demo
 * @Author haoZe
 * @Date 2023/10/24
 **/
public class CompletableFutureAPI2Demo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(()->{

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        },threadPool).handle((f,e)->{
            int i= 1/0;
            System.out.println("222");
            return f+2;
        }).handle((f,e)->{
            System.out.println("333");
//            int i= 1/0;
            return f+3;
        }).whenComplete((v,e)->{
            if (e==null){
                System.out.println("------计算结果："+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("抛异常了："+e.getMessage());
            return null;
        });

        System.out.println("------主线程先去忙其他的了");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }
}

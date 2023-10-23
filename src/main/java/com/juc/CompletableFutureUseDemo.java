package com.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author haoze
 * @create 2023/10/23 17:04
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"------come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            System.out.println("------1秒钟后结果"+result);
            return result;
        }).whenComplete((v,e)->{
            if (e==null){
                System.out.println("------计算完成，更新系统 UpdateVa:"+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("异常情况"+e.getCause()+"\t"+e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName()+"线程去忙其他的");

        TimeUnit.SECONDS.sleep(3);
    }
}

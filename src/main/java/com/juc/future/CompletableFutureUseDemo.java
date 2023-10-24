package com.juc.future;

import java.util.concurrent.*;

/**
 * @author haoze
 * @create 2023/10/23 17:04
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"------come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int result = ThreadLocalRandom.current().nextInt(10);
            System.out.println("------1秒钟后结果"+result);
            return result;
        },threadPool).whenComplete((v,e)->{
            if (e==null){
                System.out.println("------计算完成，更新系统 UpdateValue:"+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("异常情况"+e.getCause()+"\t"+e.getMessage());
            return null;
        });
        threadPool.shutdown();

        System.out.println(Thread.currentThread().getName()+"线程去忙其他的");
        //主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭：暂停3秒钟
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

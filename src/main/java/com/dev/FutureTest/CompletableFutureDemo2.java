package com.dev.FutureTest;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureDemo2
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/8/30
 * @Version TODO
 * @History TODO
 **/
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },threadPool);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello supplyAsync";
        },threadPool);

        threadPool.shutdown();
        System.out.println(completableFuture.get());
    }
}

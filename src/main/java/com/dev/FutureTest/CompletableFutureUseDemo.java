package com.dev.FutureTest;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureUseDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/8/30
 * @Version TODO
 * @History TODO
 **/
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "---come in");

                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1秒钟后结果是:" + result);
                if (result > 5) {
                    int i = 1 / 0;
                }
                return result;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("更新结果为" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况" + e.getCause() + "\t" + e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName() + "先去做别的了");
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
//        future1();

    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---come in");

            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1秒钟后结果是:" + result);
            return result;
        });
        System.out.println(Thread.currentThread().getName() + "先去做别的了");
        System.out.println(completableFuture.get());
    }
}

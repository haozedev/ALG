package com.dev.FutureTest;

import java.util.concurrent.*;

/**
 * @ClassName FutureThreadPoolDemo
 * @Description TODO
 * @Author haoZe
 * @Date 2022/8/29
 * @Version TODO
 * @History TODO
 **/
public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over";
        });
        threadPool.submit(futureTask1);
        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over";
        });
        threadPool.submit(futureTask2);

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("used" + (endTime - startTime) + "毫秒");
        System.out.println(Thread.currentThread().getName()+"\t ----end");
        threadPool.shutdown();

        m1();

    }

    private static void m1() {
        long startTime = System.currentTimeMillis();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("used" + (endTime - startTime) + "毫秒");
    }
}

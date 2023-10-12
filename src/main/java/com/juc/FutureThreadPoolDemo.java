package com.juc;

import java.util.concurrent.*;

/**
 * @ClassName FutureThreadPoolDemo
 * @Author haoZe
 * @Date 2023/4/24
 **/
public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1 over";
        });
        executorService.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2 over";
        });
        executorService.submit(futureTask2);

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");
        System.out.println(Thread.currentThread().getName() + "\t ------ end");
        executorService.shutdown();

//        m1();
    }

    private static void m1() {
        //三个任务，目前只一个线程main来处理，问耗时多少
        long startTime = System.currentTimeMillis();
        //暂停ms
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + " ms");
        System.out.println(Thread.currentThread().getName() + "\t ------ end");

    }

}

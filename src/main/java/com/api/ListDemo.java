package com.api;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ListDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/9/9
 * @Version TODO
 * @History TODO
 **/
public class ListDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("a",3L, TimeUnit.SECONDS));
        ForkJoinPool forkJoinPool = new ForkJoinPool();
    }
}

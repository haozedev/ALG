package com.dev;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockingQueueDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/29
 * @Version TODO
 * @History TODO
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

//        System.out.println(blockingQueue.remove());
//
//        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    }
}

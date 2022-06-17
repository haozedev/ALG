package com.dev;

import java.util.*;
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

        Collection<String> c  = new ArrayList<>();

        ArrayList<String> s = new ArrayList<>();

        //给 set 加上 Comparator自带排序了
        TreeSet<Integer> i = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        i.add(1);
        i.add(2);
        i.add(6);
        i.add(4);
        System.out.println(i);
    }
}

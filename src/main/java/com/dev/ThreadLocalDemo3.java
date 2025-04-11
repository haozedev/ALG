package com.dev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haoze
 * @create 2025/4/11 15:58
 * @description
 */
public class ThreadLocalDemo3 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    try {
                        Integer beforeInt = myData.threadLocal.get();
                        myData.add();
                        Integer afterInt = myData.threadLocal.get();
                        System.out.println(Thread.currentThread().getName()+"\t"+beforeInt+"\t"+afterInt);
                    } finally {
                        myData.threadLocal.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            threadPool.shutdown();
        }


    }



    static class MyData{
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);

        public void add(){
            threadLocal.set(1+threadLocal.get());
        }
    }
}

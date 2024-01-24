package com.dev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLocalDemo2
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/21
 * @Version TODO
 * @History TODO
 **/
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        MyData myData = new MyData();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    try {
                        Integer before = myData.threadLocalField.get();
                        myData.add();
                        Integer after = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName()+"\t"+"before:"+before
                                +"\t after:"+after);
                    } finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();

        }
    }
}

class MyData{
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(()->0);
    public void add(){
        threadLocalField.set(1+threadLocalField.get());
    }
}

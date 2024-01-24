package com.dev;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/31
 * @Version TODO
 * @History TODO
 **/

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("****************come in Callable");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();


        System.out.println(Thread.currentThread().getName()+"**********");
        int result1 = 100;
        //放最后面，算完了执行main线程
        Integer result2 = futureTask.get();
        System.out.println("******" + (result1+result2));
    }
}

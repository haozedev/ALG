package com.dev.FutureTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CompletableFutureDemo
 * @Description TODO
 * @Author haoZe
 * @Date 2022/8/29
 * @Version TODO
 * @History TODO
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<String>
{
    @Override
    public String call() throws Exception {
        System.out.println("--------come in call()");
        return "hello Callable";
    }
}

package com.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName FutureAPIDemo
 * @Author haoZe
 * @Date 2023/3/21
 **/
public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t-----come in");
            TimeUnit.SECONDS.sleep(3);
            return "task over";
        });
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        System.out.println(Thread.currentThread().getName()+"\t------忙其他任务了");

//        System.out.println(futureTask.get());//必须等结果，容易导致堵塞，一般建议放最后，假如不想等很久，可以过时不候自动离开

        while (true){
            if (futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("\t正在处理中");
            }
        }
    }
}

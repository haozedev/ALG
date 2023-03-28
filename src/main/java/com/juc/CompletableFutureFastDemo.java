package com.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureFastDemo
 * @Author haoZe
 * @Date 2023/3/22
 **/
public class CompletableFutureFastDemo {
    public static void main(String[] args) {
        CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {
            System.out.println("A come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "a";
        });

        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {
            System.out.println("B come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "b";
        });

        CompletableFuture<String> result = playA.applyToEither(playB,f->{
            return f+" is winner";
        });

        System.out.println(Thread.currentThread().getName()+"\t"+"------"+result.join());
    }
}

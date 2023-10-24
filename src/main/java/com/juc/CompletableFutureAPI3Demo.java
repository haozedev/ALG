package com.juc;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompletableFutureAPI3Demo
 * @Author haoZe
 * @Date 2023/10/24
 **/
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
//        CompletableFuture.supplyAsync(()->{
//            return 1;
//        }).thenApply(f->{
//            return f+2;
//        }).thenApply(f->{
//            return f+3;
//        }).thenAccept(System.out::println);

        System.out.println(CompletableFuture.supplyAsync(()->{
            System.out.println("----task");
            return "resultA";
        }).thenRun(()->{
            System.out.println("干别的去了");

        }).join());

        System.out.println(CompletableFuture.supplyAsync(()-> "resultB").thenAccept((r)-> System.out.println(r)
        ).join());

        System.out.println(CompletableFuture.supplyAsync(()-> "resultB").thenApply((r)-> r+"resultC"
        ).join());
    }
}

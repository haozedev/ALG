package com.dev.FutureTest;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class CompletableFutureCase {
    static List<NetMall> list = Arrays.asList(
            new NetMall("JD"),
            new NetMall("dangDang"),
            new NetMall("taoBao")
    );

    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list
                .stream()
                .map(netMall -> String.format(productName + " in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream().map(netMall ->
                CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(s -> s.join())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<String> mysql = getPrice(list, "mysql");

        for (String ele : mysql) {
            System.out.println(ele);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime" + (endTime - startTime) + "毫秒");
        System.out.println("--------------");
        long startTime1 = System.currentTimeMillis();

        List<String> mysql1 = getPriceByCompletableFuture(list, "mysql");

        for (String ele : mysql1) {
            System.out.println(ele);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("----costTime" + (endTime1 - startTime1) + "毫秒");
    }
}

class NetMall {

    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * +productName.charAt(0);
    }
}

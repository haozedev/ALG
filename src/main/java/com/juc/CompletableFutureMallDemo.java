package com.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author haoze
 * @create 2023/10/24 15:11
 */
public class CompletableFutureMallDemo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("pdd"),
            new NetMall("tm"),
            new NetMall("taobao")
    );

    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list
                .stream()
                .map(netMall -> String.format(productName + "in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list
                .stream()
                .map(netMall ->
                        CompletableFuture.supplyAsync(() -> String.format(productName + "in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream().map(s -> s.join())
                .collect(Collectors.toList());

    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<String> list1 = getPrice(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");

        long startTime1 = System.currentTimeMillis();
        List<String> list2 = getPriceByCompletableFuture(list, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1 + "ms");
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

        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }

}

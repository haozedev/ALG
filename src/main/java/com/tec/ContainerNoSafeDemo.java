package com.tec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author lingfeng
 * @create 2022/5/26 11:17
 */
public class ContainerNoSafeDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        //java.util.ConcurrentModificationException
        }
    }
}

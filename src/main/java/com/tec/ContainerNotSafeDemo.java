package com.tec;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/** 集合类不安全实例
 * 故障现象：
 *          ArrayList java.util.ConcurrentModificationException
 *
 *  产生原因：
 *          并发争抢修改导致，参考花名册签名情况
 *          一个人在写入，另一个人过来抢夺，导致数据不一致异常，并发修改异常。
 *
 *  解决方案：1.new Vector<>();
 *          2.Collections.synchronizedList(new ArrayList<>());
 *          3.new CopyOnWriteArrayList<>();
 *          4.new ConcurrentHashMap<>();
 *          5.Collections.synchronizedMap(new HashMap<>());
 * @author lingfeng
 * @create 2022/4/5 9:11
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //add()方法，默认value是PRESENT
        new HashSet<>().add("a");
    }

}

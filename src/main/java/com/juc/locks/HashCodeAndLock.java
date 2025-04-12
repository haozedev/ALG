package com.juc.locks;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class HashCodeAndLock {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("未调用hashCode前对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

        obj.hashCode();
        System.out.println("调用hashCode后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            System.out.println("进入同步块后对象头：\n" + ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}

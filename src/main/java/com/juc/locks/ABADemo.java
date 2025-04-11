package com.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author haoze
 * @create 2025/4/11 14:39
 * @description
 */
public class ABADemo {
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"first : "+stamp);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t"+"second:"+stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t"+"third:"+stampedReference.getStamp());
        },"t1").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"first : "+stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = stampedReference.compareAndSet(100, 2022, stamp, stamp + 1);
            System.out.println(b+","+stampedReference.getReference()+"\t"+"t2:"+stampedReference.getStamp());
        },"t2").start();
    }

}

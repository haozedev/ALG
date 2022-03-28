package com.tec;

import java.util.concurrent.TimeUnit;

/**
 * @author lingfeng
 * @create 2022/3/27 9:36
 */
class MyData{
    volatile int num = 0;

    public void addTo60(){
        this.num = 60;
    }
}
public class VolatileTest {

    public static void main(String[] args) {
        seeOkByVolatile();

    }

    /**
     *  volatile保证其可见性，即使同时其他线程，主物理内存已经被修改
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\tcome in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"update num value\t"+myData.num);
        },"AAA").start();

        while (myData.num==0){

        }
        System.out.println(Thread.currentThread().getName()+"update num value\t"+myData.num);
    }
}

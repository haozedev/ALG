package com.dev;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/21
 * @Version TODO
 * @History TODO
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i <= 5; i++) {
            new Thread(()->{
                int size = new Random().nextInt(5)+1;
                try {
                    for (int i1 = 1; i1 < size; i1++) {
                        house.saleHouse();
                        house.saleVolumeByThreadLocal();
                    }
                    System.out.println(Thread.currentThread().getName()+house.saleVolume.get());
                } finally {
                    house.saleVolume.remove();
                }
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("总数"+house.saleCount);
    }
}

class House {
    int saleCount = 0;

    public synchronized void saleHouse() {
        ++saleCount;
    }

    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(() -> 0);

    public void saleVolumeByThreadLocal(){
        saleVolume.set(1+saleVolume.get());
    }
}

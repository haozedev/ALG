package com.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SaleTicketDemo
 * @Author haoZe
 * @Date 2023/10/31
 **/
public class SaleTicketDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"a").start();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"b").start();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"c").start();
    }
}

class Ticket {

    private int number = 50;

    ReentrantLock lock = new ReentrantLock(true);

    public void sale(){
        lock.lock();
        try {
            if (number>0){

                System.out.println(Thread.currentThread().getName()+"卖出第:"+(number--)+",\t 还剩下:"+number);
            }
        } finally {
            lock.unlock();
        }
    }

}

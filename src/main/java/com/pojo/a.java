package com.pojo;

/**
 * @ClassName a
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/27
 * @Version TODO
 * @History TODO
 **/
public class a {

    public static Object a = "a";
    public static Object b = "b";

    public static void main(String[] args) {

        LOCKa locKa = new LOCKa();
        Thread t1 = new Thread(locKa);
        t1.start();
        LOCKb locKb = new LOCKb();
        Thread t = new Thread();
        t.setDaemon(true);
        t.start();

    }
}

class LOCKa implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("LOCKa在执行");
            synchronized (a.a) {
                System.out.println("锁住了a");
                try {
                    Thread.sleep(3000);

                    synchronized (a.b) {
                        System.out.println("需要B");
                        Thread.sleep(60 * 1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class LOCKb implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("LOCKb在执行");
            synchronized (a.b) {
                System.out.println("锁住了b");
                synchronized (a.a) {
                    System.out.println("需要a");
                }
            }
        }
    }
}
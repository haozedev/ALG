package com.dev;

/**
 * @author haoze
 * @create 2025/4/9 10:53
 * @description
 */
public class SafeStopWaitFlag implements Runnable {
    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                System.out.println(Thread.currentThread().getName() + "is running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "error,make flag false");
                Thread.currentThread().interrupted();
            }
        }
        System.out.println(Thread.currentThread().getName() + "is stop now!");

    }

    public void stop() {
        System.out.println("flag false");
        flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        SafeStopWaitFlag task = new SafeStopWaitFlag();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(300);

        task.stop();
    }
}

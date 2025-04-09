package com.dev;

/**
 * @author haoze
 * @create 2025/4/9 11:11
 * @description
 */
public class InterruptExample implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                System.out.println("Working...");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Interrupted during sleep");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread terminated by interrupt");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptExample());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}

package com.juc.future;

import java.util.concurrent.Callable;

/**
 * @author haoze
 * @create 2023/10/12 10:37
 */
public class CompleteFutureDemo {
    public static void main(String[] args) {

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        return null;
    }
}

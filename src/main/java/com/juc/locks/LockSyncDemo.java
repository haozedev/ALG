package com.juc.locks;

/**
 * @ClassName LockSyncDemo
 * @Author haoZe
 * @Date 2023/10/30
 **/
public class LockSyncDemo {
    Object object = new Object();
    public void m1(){
        synchronized (object){
            System.out.println("----hello synchronized code lock");
        }
    }
    public static void main(String[] args) {

    }



}

package com.juc.locks;

import java.util.concurrent.TimeUnit;

/**
 * @author haoze
 * @create 2023/10/27 13:55
 */
/*
* 8锁案例说明:
* 1标准访问有ab 两个线程，请问先打印邮件还是短信
* 2sendEmail 方法中加入暂停3秒钟，请问先打印邮件还是短信米
* 3添加一个普通的helLo 方法，请同先打印邮件还是hello
* 4有两部手机，请回先打印邮件还是短信
* 5有两个静态同步方法，有1 部手机，请问先打印邮件还是短信
* 6有两个静态同步方法，有2部手机，请向先打印邮件还是短信
* 7有1个静态同步方法，有1 个普通同步方法,有1部手机，请问先打印邮件还是短信
* 8有1个静态同步方法，有1个普通同步方法,有2部手机，请问先打印邮件还是短信
* */
public class Lock8Demo {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        },"a").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Phone phone2 = new Phone();

        new Thread(() -> {
            phone.sendSMS();
//            phone2.sendSMS();
        },"b").start();
    }
}

class Phone {
    public static synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("sendSMS");
    }

    public void hello(){
        System.out.println("Hello");
    }
}

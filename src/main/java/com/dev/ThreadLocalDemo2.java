package com.dev;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLocalDemo2
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/21
 * @Version TODO
 * @History TODO
 **/
public class ThreadLocalDemo2 {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        // 创建一个TransmittableThreadLocal变量

            // 设置主线程的context值
            context.set("Main Thread Context");

            // 创建一个线程池并用TtlExecutors包装，以支持TransmittableThreadLocal
            ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));

            // 提交任务到线程池
            executorService.submit(() -> {
                // 子线程获取context值
                System.out.println("Child Thread Context: " + context.get());
            });

            // 改变主线程的context值
            context.set("Updated Main Thread Context");

            // 再次提交任务到线程池
            executorService.submit(() -> {
                // 子线程获取更新后的context值
                System.out.println("Child Thread Context After Update: " + context.get());
            });

            executorService.shutdown();
    }

    /**
     * threadLocal测试
     */
    public static void testThreadLocal() {
        // 在主线程中设置值到threadLocal
        threadLocal.set("我是父线程threadLocal的值");

        // 创建一个新线程并启动
        new Thread(() -> {
            // 在子线程里面无法获取到父线程设置的threadLocal，结果为null
            System.out.println("从子线程获取到threadLocal的值: " + threadLocal.get());
        }).start();
    }

    /**
     * inheritableThreadLocal测试
     */
    public static void testInheritableThreadLocal() {
        // 在主线程中设置一个值到inheritableThreadLocal
        inheritableThreadLocal.set("我是父线程inheritableThreadLocal的值");

        // 创建一个新线程并启动
        new Thread(() -> {
            // 在子线程里面可以自动获取到父线程设置的inheritableThreadLocal
            System.out.println("从子线程获取到inheritableThreadLocal的值: " + inheritableThreadLocal.get());
        }).start();
    }

}

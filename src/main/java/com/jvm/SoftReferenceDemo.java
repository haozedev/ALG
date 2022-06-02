package com.jvm;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReferenceDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/2
 * @Version TODO
 * @History TODO
 **/

public class SoftReferenceDemo {
    public static void main(String[] args) {
        softRef_Memory_Enough();
    }

    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
//        System.gc();

        try {
//            byte[] bytes = new byte[100 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }
}

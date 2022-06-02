package com.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @ClassName WeakReferenceDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/2
 * @Version TODO
 * @History TODO
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {
        weakRef_Memory_Enough();
    }

    public static void weakRef_Memory_Enough() {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());

        o1=null;
        System.gc();
        System.out.println("--------------");
            System.out.println(o1);
            System.out.println(weakReference.get());

    }
}

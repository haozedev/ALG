package com.jvm;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

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

        //设计思路：用一个HashMap来保存图片的路径和相应对象关联的软引用之间的映射关系，
        // 内存不足时，JVM会自动回收这些缓存图片所占用的空间，从而有效的避免OOM问题
        // mybatis大量使用软引用
//        Map<String,SoftReference<Bitmap>> imageCache = new HashMap<String,SoftReference<Bitmap>>();

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

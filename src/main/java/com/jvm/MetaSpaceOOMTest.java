package com.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName MetaSpaceOOMTest
 * @Description 元空间溢出
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/3
 * @Version TODO
 * @History TODO
 **/
public class MetaSpaceOOMTest {
    static class OOMTest {

    }

    public static void main(String[] args) {
        int i = 0;//模拟多少次后发生异常

        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("发生异常次数" + i);
            e.printStackTrace();
        }

    }
}

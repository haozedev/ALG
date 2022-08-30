package com.util;

import java.lang.reflect.Method;

public class CallMethod {

    /**
     * 通过字符串串调用方法
     *
     * @param classAndMethod 类名-方法名，通过此字符串调用类中的方法
     * @param paramTypes     方法类型列表(因为方法可能重载)
     * @param params         需要调用的方法的参数列表
     * @return
     */
    public static Object call(String classAndMethod, Class[] paramTypes, Object[] params) {
        String[] args = classAndMethod.split("-");
        //要调用的类名
        String className = args[0];
        //要调用的方法名
        String method = args[1];
        try {
            //加载类，参数是完整类名
            Class clazz = Class.forName(className);

            //第一个参数是方法名，后面的参数指示方法的参数类型和个数
            Method method1 = clazz.getMethod(method, paramTypes);

            //accessiable设为true表示忽略java语言访问检查（可访问private方法）
            //method.setAccessible(true);

            //第一个参数类实例(必须有对象才能调用非静态方法,如果是静态方法此参数可为null)
            //第二个是要传给方法的参数
            Object result = method1.invoke(clazz.newInstance(), params);

            return result;

            //这里为了博客上简洁一些把其他catch都去掉了(复制代码的同学应该把其他异常的catch搞出来)
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

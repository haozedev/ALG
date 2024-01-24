package com.util;

/**
 * @ClassName CallTest
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/7/29
 * @Version TODO
 * @History TODO
 **/
public class CallTest {
    public static void main(String[] args) {
        //我们测试要调用的hello方法只有一个String参数
        Class[] paramTypes={String.class};

        //给hello方法传参数"World"
        Object[] params={"World"};

        Object result=CallMethod.call("com.util.MyTest-hello",paramTypes,params);

        //已测试输出 "Hello World"
        System.out.println((String)result);
    }

}

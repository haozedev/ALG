package com.jvm;

/**
 * @ClassName StackOverFlowErrorDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/3
 * @Version TODO
 * @History TODO
 **/
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        //StackOverflowError 内存溢出
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}

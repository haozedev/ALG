package com.alg;

/**
 * @ClassName getLastStrLen
 * @Description TODO
 * @Author haoZe
 * @Date 2022/6/8
 * @Version TODO
 * @History TODO
 **/
public class getLastStrLen {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println(getStrLen(str));
    }

    /**
     *@Description
     *@Param str
     *@Return int
     *@Author HaoZe
     *@Date 2022/6/8
     **/
    public static int getStrLen(String str){

        if (str.length()<=0){
            return 0;
        }
        String[] split = str.split("\u0020");

        return split[split.length-1].length();

    }
}

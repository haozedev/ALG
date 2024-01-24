package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName randomApi
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/9/6
 * @Version TODO
 * @History TODO
 **/
public class randomApi {
    public static void main(String[] args) {
        String num = "123456";

        int i = 0;

        Logger logger = LoggerFactory.getLogger(randomApi.class);

        logger.info("日志{},问题{}",num,i);



        String s = String.format("%-20s","0");

        System.out.println(s);

        String s1 = "(111)";
        boolean contains = s1.contains("(");
        System.out.println(contains);
        String substring = s1.substring(s1.indexOf("(")+1, s1.indexOf(")"));
        System.out.println(substring);

        String s2 = "0123 20";
        String s3 = s2.replaceFirst("0", "").replaceAll(" ","");
        System.out.println(s3);
    }
}

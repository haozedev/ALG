package com.tec;

import java.sql.Date;

/**
 * @author lingfeng
 * @create 2022/4/16 17:01
 */
public class time {
    public static void main(String[] args) {
        String s = new Date(System.currentTimeMillis()).toString();

        System.out.println(s);

        String s1 = s.replaceAll("-", "");

        System.out.println(s1);
    }
}

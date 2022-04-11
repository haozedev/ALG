package com.tec;

import java.sql.Date;
import java.sql.Time;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/3/10 17:29
 */
public class TimeChange {

    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()).toString());
        System.out.println(new Time(System.currentTimeMillis()).toString());
        String format = String.format("%-10s", "66");
        System.out.print(format);
        System.out.println("00");
    }
}

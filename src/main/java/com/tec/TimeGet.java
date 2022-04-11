package com.tec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/3/23 17:33
 */
public class TimeGet {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        System.out.println(dateName);
    }
}

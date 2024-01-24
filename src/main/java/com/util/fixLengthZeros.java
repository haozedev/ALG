package com.util;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName fixLengthZeros
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/8/31
 * @Version TODO
 * @History TODO
 **/
public class fixLengthZeros {
    public static void main(String[] args) {
//        System.out.println(fixLength("51662", 6));
        String str = "0123";
        String substring = str.substring(2,str.length());
        System.out.println(substring);
    }

    private static String fixLength(String str ,int length) {
        String format = "%0" + length + "d";
        if (StringUtils.isNotEmpty(str)){
            return String.format(format,Long.parseLong(str));
        }
        return null;
    }
}

package com.pojo.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lingfeng
 * @create 2022/3/25 21:13
 */
@Component
public class MethodDO {

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * @param str
     * @return
     */
    public static int getStrLength(String str){
        String[] s = str.split(MethodConstant.space);
        String s1 = s[s.length-1];
        return s1.length();
    }
}

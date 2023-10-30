package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述集合去重运行该段代码
 * List<String> list = new ArrayListkString>0 list.add("123abccd")，
 * list.add("abcdc123"); list.add("1234abc"), list.add("ab1234cd");
 * 每个列表元素中由一个数字中和若干字母构成，
 * 若两个元素中的数字串相同则认为元素相等(例如:123abcd限abcdc123,存在相同的数字串123)，
 * 一段代码，删除列表中的相等元素(相等的只保留一个)
 */
public class tanmaFace01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() ;
        list.add("123abccd");
        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("ab1234cd");
        for (int i= 0;i<list.size();i++){
            for (int j = i+1;j<list.size();j++){
                String s1 = list.get(i);
                String s2 = list.get(j);
                if (s1.equals(s2)){
                    list.remove(j);
                }
            }
        }
        for (String s : list) {
            System.out.println(s);
        }

    }
}

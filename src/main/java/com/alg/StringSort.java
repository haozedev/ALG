package com.alg;

import java.util.*;

/**
 * @ClassName StringSort
 * @Description HJ14 字符串排序
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/14
 * @Version TODO
 * @History TODO
 **/
public class StringSort {

    public static void main(String[] args) {
        //描述
        //给定 n 个字符串，请对 n 个字符串按照字典序排列。
        //
        //数据范围：  ，字符串长度满足
        //输入描述：
        //输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
        //输出描述：
        //数据输出n行，输出结果为按照字典序排列的字符串。
        // 此题不能使用TreeSet数据结构进行默认排序
        // 隐藏坑点：输入字符串存在重复可能，且此题不要求去重
        Scanner sc = new Scanner(System.in);
        int lineNum =Integer.parseInt(sc.nextLine()) ;
        List<String> list = new ArrayList<>();
        for(int i = 0;i<lineNum;i++){
            list.add(sc.nextLine());
        }
        list.stream().sorted().forEach(word ->{
            System.out.println(word);
        });
    }
}

package com.alg;

import com.pojo.MethodDO;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName mingRandomNum
 * @Description 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
 * @Author ty-ChaiHaoZe
 * @Date 2022/7/1
 * @Version TODO
 * @History TODO
 **/
public class mingRandomNum {
    public static void main(String[] args) {

//        int [] ints = {7,1,2,2,2,4,3,3,1,5,6};
//
//        Object[] objects = MethodDO.randomNum(ints);
//        for (Object object : objects) {
//            System.out.println(object);
//        }
//        String s = "d!";
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i)-0);
//        }

//        String s = String.valueOf((char)(102));
//
//        System.out.println((char)(102));
//        System.out.println((char)(97));
//        System.out.println((char)(107));
//        System.out.println((char)(97));
//        System.out.println((char)(37));
//        System.out.println((char)(116));
//        System.out.println((char)(100));
//        System.out.println((char)(115));
//        System.out.println((char)(113));
//        System.out.println((char)(108));
//        System.out.println((char)(56));
//        System.out.println((char)(54));
//        System.out.println((char)(33));

        char [] chars = {(char)(33),(char)(102)};

        StringBuilder pas = new StringBuilder();
        for (char c : chars) {
            pas.append(String.valueOf(c));
        }
        System.out.println(pas);
    }
}

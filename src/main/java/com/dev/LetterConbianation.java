package com.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/1/23 14:00
 */
public class LetterConbianation {
    public static void main(String[] args) {
        String num = "23";
        List<String> strings = letterCombinations(num);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //设置全局列表存储最后的结果
//    List<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        list=backTracking(digits, numString, 0);

        return list;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
//    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public static List<String> backTracking(String digits, String[] numString, int num) {
        StringBuilder temp = new StringBuilder();
        List<String> list = new ArrayList<>();
        //遍历全部一次,记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return list;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
        return list;
    }

}

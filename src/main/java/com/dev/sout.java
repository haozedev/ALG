package com.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/1/23 14:45
 */
public class sout {
    public static void main(String[] args) {
        String num = "24";
        List<String> strings = letterCombination(num);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> letterCombination(String digits) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTrack(temp, list, digits, numString, 0);

        return list;


    }

    private static void backTrack(StringBuilder temp, List<String> list, String digits, String[] numString, int num) {
        //如果i=2说明要越界了，长度为2但只能读到1(0开始的)
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //获取digits中的第i个数值，比如i=0,就是获取“23”中的2
        String str = numString[digits.charAt(num) - '0'];
        for (int i1 = 0; i1 < str.length(); i1++) {
            //temp现在有一个字母了 a
            temp.append(str.charAt(i1));
            //num+1 去下一层给a后面加字母 ad,ae,af
            backTrack(temp, list, digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }


    }
}

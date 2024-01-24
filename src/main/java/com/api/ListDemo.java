package com.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName ListDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/9/9
 * @Version TODO
 * @History TODO
 **/
public class ListDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("001");

        for (String s : arrayList) {
            System.out.println(s);
        }
        Pattern pattern = Pattern.compile("[0]*"); // 验证数字
        // Pattern pattern = Pattern.compile("-?[0-9]+?[0-9]+");(与上一行同效果)

        Matcher matcher = pattern.matcher("000 0");
        System.out.println(matcher.matches());
    }
}

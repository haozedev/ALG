package com.dev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/13
 * @Version TODO
 * @History TODO
 **/
public class StreamDemo {
    public static void main(String[] args) {

        //
        ArrayList<String> list1 = new ArrayList<>();

        Collections.addAll(list1,"张三","张三丰","张翠山","张无忌","张无忌","张朝阳","谢逊");

        list1.stream().filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(s-> System.out.println(s));

        //stream去重
        List<String> list = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}

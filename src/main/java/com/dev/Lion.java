package com.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaihaoze
 * @create 2021/9/5 18:30
 */
public class Lion {
    public static void main(String[] args) {
        List<Integer> ages = new ArrayList<Integer>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("6"));
        ages.add(7);
        ages.add(null);
        for (int age : ages) System.out.print(age);
    }
}


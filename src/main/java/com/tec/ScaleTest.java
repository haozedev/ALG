package com.tec;

import java.math.BigDecimal;

/**
 * @author lingfeng
 * @create 2022/5/21 11:47
 */
public class ScaleTest {
    public static void main(String[] args) {
        BigDecimal avl = new BigDecimal("17.88888");
        BigDecimal bigDecimal = avl.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }
}

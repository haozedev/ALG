package com.alg;

import com.pojo.MethodDO;

/**
 * @author lingfeng
 * @create 2022/3/25 22:10
 */
public class getFirstAndLastTest {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] firstAndLast = MethodDO.getFirstAndLast(nums, target);

        for (int i : firstAndLast) {
            System.out.println(i);
        }
    }
}

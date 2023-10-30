package com.alg;

import com.pojo.MethodDO;

/**
 * @author lingfeng
 * @create 2022/4/4 21:05
 */
public class NextPermutationTest {
    public static void main(String[] args) {
        int [] nums = {1,2,4,3};
        MethodDO.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

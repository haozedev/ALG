package com.alg;

import java.util.Arrays;

/**
 * @author lingfeng
 * @create 2021/11/28 21:15
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。
 * 如果数组中每个元素都不相同，则返回 false 。
 */
public class containsDuplicateDemo {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,3};
        boolean b = containsDuplicate(arr);
        System.out.println(b);
    }
    public static boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                flag=true;
            }
        }
        return flag;
    }
}

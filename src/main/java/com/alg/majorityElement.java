package com.alg;

import java.util.Arrays;

/**
 * @author haoze
 * @description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @create 2021/12/5 17:16
 */
public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 1, 1, 2, 2};
        System.out.println(method(nums));
    }

    public static int method(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

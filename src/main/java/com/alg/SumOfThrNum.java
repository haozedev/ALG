package com.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HaoZ
 * @ClassName
 * @description给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 MonitorDo，b，c ，使得 MonitorDo + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * @create 2022/1/24 11:00
 */
public class SumOfThrNum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> lists = threeSum(result, nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(List<List<Integer>> result, int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            //错误去重
//            if (i > 0 && nums[i] == nums[i + 1]) {
//                continue;
//            }
            //正确去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    --right;
                    ++left;
                }
            }

        }
        return result;
    }
}

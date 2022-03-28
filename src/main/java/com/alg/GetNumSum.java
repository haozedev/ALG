package com.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/1/23 11:00
 */
public class GetNumSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 11};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * @Description
     * @Param nums
     * @Param target
     * @Return int[]
     * @Author HaoZe
     * @Date 2022/1/23
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

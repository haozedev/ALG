package com.alg;

import java.util.Arrays;

/**
 * @author haoze
 * @create 2021/12/5 16:58
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumberTest {
    public static void main(String[] args) {
        int[]nums ={1,1,2,3,3};
        int i = singleNumber(nums);
        System.out.println(i);

    }
    public static int singleNumber(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        //两两比较即可
        for (int i = 1; i < nums.length-1; i+=2) {
            if (nums[i]==nums[i-1]){
                continue;
            }else{
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}

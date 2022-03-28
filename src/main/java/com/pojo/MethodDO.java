package com.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lingfeng
 * @create 2022/3/25 21:13
 */
@Component
public class MethodDO {

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     *
     * @param str
     * @return
     */
    public static int getStrLength(String str) {
        String[] s = str.split(MethodConstant.space);
        String s1 = s[s.length - 1];
        return s1.length();
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getFirstAndLast(int[] nums, int target) {

        int[] result = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                result[0] = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//(right+left)/2可能会溢出
            if (nums[mid]<target){
                left = mid + 1;
            }else if (nums[mid]>target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return right + 1;
    }
}
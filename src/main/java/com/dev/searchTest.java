package com.dev;

/**
 * @author haoze
 * @description 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * @create 2021/12/7 20:33
 */
public class searchTest {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 3));
    }

    /**
     *@Description
     *@Param nums
     *@Param target
     *@Return int
     *@Author ty-ChaiHaoZe
     *@Date 2022/1/22
     **/
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (target > num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

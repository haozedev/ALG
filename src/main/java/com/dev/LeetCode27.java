package com.dev;

/**
 * @author lingfeng
 * @create 2022/3/23 21:08
 */
public class LeetCode27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     *  快慢指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
}

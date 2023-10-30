package com.alg;

/**
 * @author haoze
 * @description 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1和 2 分别表示红色、白色和蓝色。
 * @create 2021/12/6 18:56
 */
public class sortColorsTest {
    public static void main(String[] args) {
        //输入：nums = [2,0,2,1,1,0]
        //输出：[0,0,1,1,2,2]

    }

    public static void method(int[] nums) {
//        Arrays.sort(nums);
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}

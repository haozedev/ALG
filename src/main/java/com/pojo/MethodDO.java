package com.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
     *
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
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    // [i + 1, nums.length) 内元素升序排序
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums); // 不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    }

    /**
     * @Description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * @Param intervals
     * @Return int[][]
     * @Author HaoZe
     * @Date 2022/4/11
     **/
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            //当前数组1与前一个数组0比较
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i][1]});
                start = intervals[i - 1][0];
            } else {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[1][1]);
            }
        }

        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }

    /**
     * @Description
     * @Param matrix
     * @Return java.util.List<java.lang.Integer>
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/27
     **/
    public List<Integer> spiralOrder(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        //行
        int rows = intervals.length;
        //列
        int columns = intervals[0].length;
        //总数
        int total = rows * columns;

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }

        return null;
    }

    /**
     *@Description
     *@Param str
     *@Return int
     *@Author HaoZe
     *@Date 2022/6/8
     **/
    public int getStrLen(String str){
        if (str.length()<=0){
            return 0;
        }
        String[] split = str.split("\u0020");

        return split[split.length-1].length();

    }
}

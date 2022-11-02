package com.pojo;

import org.springframework.stereotype.Component;

import java.util.*;

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
     *@Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *              输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     *              输出：[1,2,3,6,9,8,7,4,5]
     * @Param matrix
     * @Return java.util.List<java.lang.Integer>
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/27
     **/
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<Integer>();
            if(matrix == null || matrix.length == 0)
                return list;
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;

            //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
            int count = (Math.min(m, n)+1)/2;
            //从外部向内部遍历，逐层打印数据
            while(i < count) {
                for (int j = i; j < n-i; j++) {
                    list.add(matrix[i][j]);
                }
                for (int j = i+1; j < m-i; j++) {
                    list.add(matrix[j][(n-1)-i]);
                }

                for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                    list.add(matrix[(m-1)-i][j]);
                }
                for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                    list.add(matrix[j][i]);
                }
                i++;
            }
            return list;

    }

    /**
     *@Description 快慢指针
     *@Param head
     *@Return com.pojo.ListNode
     *@Author ty-ChaiHaoZe
     *@Date 2022/6/13
     **/
    public ListNode det(ListNode head) {
        ListNode fast, slow;

        fast = slow = head;

        while (slow != null && fast.next != null) {
            fast = slow.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
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

    /**
     *@Description 获取字符串的全排列
     *@Param A
     *@Return java.util.ArrayList<java.lang.String>
     *@Author HaoZe
     *@Date 2022/6/20
     **/
    public static List<String> getPermutation(String s){
        List<String> list = new ArrayList<>();//生成一个List集合来存储全排列的结果
        list.add("" + s.charAt(0));//初始化list数组，初始元素为字符串的第一个元素
        for (int i = 1; i < s.length(); i++) {
            List<String> new_list = new ArrayList<>();//创建一个临时数组来存储下一步生成的结果
            char c = s.charAt(i);//获取此时应该插入的字符
            //对当前的数组进行遍历操作
            for (String str :
                    list) {
                new_list.add(str + c);//新字符插入到字符串的后面
                new_list.add(c + str);//新字符插入到字符串前面
                //字符插入字符串中间的操作用循环完成
                for (int j = 1; j < str.length(); j++) {//新字符插入到字符串中间
                    String tem = str.substring(0, j) + c + str.substring(j);
                    new_list.add(tem);
                }
            }
            list = new_list;//将生成的新的newlist集合同步
        }
        return list;
    }

    public static Object[] randomNum(int [] arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.toArray();

    }

    /**
     *@Description 给你两个 非空 的链表，表示两个非负的整数。
     * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *@Param l1
     *@Param l2
     *@Return com.pojo.ListNode
     *@Author HaoZe
     *@Date 2022/11/2
     **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode res = new ListNode();
        int i = (l1.getVal() + l2.getVal() )% 10;
        res.setVal(i);
        while (head!=null){
            ListNode next1 = l1.getNext();
            ListNode next2 = l2.getNext();
            int i1 = (next1.getVal() + next2.getVal()) % 10;
            ListNode next3 = new ListNode();
            next3.setVal(i1);
            res.setNext(next3);
            head = head.next;

        }
        return res;
    }

}

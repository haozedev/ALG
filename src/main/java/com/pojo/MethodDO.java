package com.pojo;

import org.junit.jupiter.api.Test;
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
     * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * @Param matrix
     * @Return java.util.List<java.lang.Integer>
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/27
     **/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n) + 1) / 2;
        //从外部向内部遍历，逐层打印数据
        while (i < count) {
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }

            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                list.add(matrix[(m - 1) - i][j]);
            }
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;

    }

    /**
     * @Description 快慢指针
     * @Param head
     * @Return com.pojo.ListNode
     * @Author ty-ChaiHaoZe
     * @Date 2022/6/13
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
     * @Description
     * @Param str
     * @Return int
     * @Author HaoZe
     * @Date 2022/6/8
     **/
    public int getStrLen(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        String[] split = str.split("\u0020");

        return split[split.length - 1].length();

    }

    /**
     * @Description 获取字符串的全排列
     * @Param A
     * @Return java.util.ArrayList<java.lang.String>
     * @Author HaoZe
     * @Date 2022/6/20
     **/
    public static List<String> getPermutation(String s) {
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

    public static Object[] randomNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.toArray();

    }

    /**
     * @Description 给你两个 非空 的链表，表示两个非负的整数。
     * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @Param l1
     * @Param l2
     * @Return com.pojo.ListNode
     * @Author HaoZe
     * @Date 2022/11/2
     **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode res = new ListNode();
        int i = (l1.getVal() + l2.getVal()) % 10;
        res.setVal(i);
        while (head != null) {
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

    /**
     * 合并两个有序链表并有序返回
     *
     * @param list1
     * @param list2
     * @return
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);

        return res;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                string.append("%20");
            } else {
                string.append(c);
            }

        }
        return string.toString();
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;


    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (target == num) {
                res++;
            }
        }
        return res;
    }

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res != nums[i]) {
                break;
            }
            res++;
        }

        return res;
    }

    /**
     * 从上到下遍历二叉树
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II,从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
     * <p>
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * @param numbers 有序的
     * @return
     */
    public int minArray(int[] numbers) {
        int res = numbers[0];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                res = numbers[i];
                break;
            }
        }


        return res;
    }

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int result = 0;

        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 0;
            for (int j = i; j < split.length; j++) {
                if (temp.toString().contains(split[j])) {
                    result = Math.max(count, result);
                    break;
                }
                temp.append(split[j]);
                count++;
                if ((i == split.length - 1 && j == split.length - 1) || temp.length() == split.length - i) {
                    result = Math.max(count, result);
                }
            }
            if (count == split.length) {
                result = count;
                break;
            }
        }
        return result;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * <<<<<<< HEAD
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {

        //定义结果数组
        int n = cost.length;
        int[] db = new int[n + 1];
        db[0] = db[1] = 0;
        for (int i = 2; i <= n; i++) {
            db[i] = Math.min(db[i - 1] + cost[i - 1], db[i - 2] + cost[i - 2]);
        }
        return db[n];
    }

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * <p>
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * <p>
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int result = 0;
        //solution 1 : 求最大值
//        for (int i = 0; i < nums.length; i++) {
//           if (result<nums[i]){
//               result = nums[i];
//           }
//        }
        //solution 2 : 找峰值
        int l = 0, r = nums.length - 1, m;
        m = (r + l) / 2;
        while (l < r) {
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        result = l;


        return result;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode right = head;

        ListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }


    @Test
    public void methodTest() {
        String s = "pwwkew";
        int i = MethodDO.lengthOfLongestSubstring2(s);
        System.out.println(i);
    }
}

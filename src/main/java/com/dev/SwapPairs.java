package com.dev;

import com.domain.ListNode;

/**
 * @author HaoZ
 * @ClassName SwapPairs
 * @description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *              你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @create 2022/1/25 18:58
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        
    }
    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

}

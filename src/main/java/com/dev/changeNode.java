package com.dev;

import com.dev.pojo.ListNode;

/**
 * @author lingfeng
 * @create 2022/3/22 21:28
 */
public class changeNode {
    public static void main(String[] args) {

        ListNode fou = new ListNode(4);
        ListNode thr = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);

        one.next=two;
        two.next = thr;
        thr.next = fou;

        ListNode head = swapPairs(one);

        sout(head);
    }

    public static void sout(ListNode head){
        while (head!=null){
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head){

        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;

        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位
        }

        return dummyNode.next;
    }

}

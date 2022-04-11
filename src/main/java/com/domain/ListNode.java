package com.domain;

/**
 * @author HaoZ
 * @ClassName 链表
 * @description
 * @create 2022/1/25 19:02
 */
public class ListNode {
    // 结点的值
    int val;

    // 下一个结点
    public ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

package com.alg;

import com.pojo.ListNode;
import com.pojo.MethodDO;

/**
 * @ClassName addTwoNumbers
 * @Description TODO
 * @Author haoZe
 * @Date 2022/11/2
 * @Version TODO
 * @History TODO
 **/
public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode thr = new ListNode(3);
        ListNode two = new ListNode(4);
        ListNode one = new ListNode(2);

        one.next=two;
        two.next = thr;

        ListNode fou = new ListNode(4);
        ListNode six = new ListNode(6);
        ListNode fiv = new ListNode(5);

        fiv.next=six;
        six.next = fou;

        ListNode head = MethodDO.addTwoNumbers(one, fiv);
        while (head!=null){
            System.out.println(head.getVal());
            head = head.next;
        }
    }
}

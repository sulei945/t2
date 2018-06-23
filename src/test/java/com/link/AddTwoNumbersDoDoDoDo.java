package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2018/1/1.
 * 给定两个链表，分别表示两个非负整数，0-9。
 * 他们的数字逆序存储在链表中，且每个结点只存储一个数字，
 * 计算两个数的和，并返回和的链表头指针。
 * 如：2->4->3, 5->6->4, 输出7->0->8
 * 即：342 + 465 = 807
 *
 * 如何实现大整数运算？
 *  通过将链表中每个结点存储的数据变成更大的范围(如每个结点存10的N次方内的数)来实现
 * 如何实现乘法？
 */
public class AddTwoNumbersDoDoDoDo {

    public static void main(String[] s){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode mr = new AddTwoNumbersDoDoDoDo().myAddTwoNumbers(l1, l2);
        System.out.println(mr.getVal() + "" + mr.next.getVal() + "" + mr.next.next.getVal());

        ListNode result = new AddTwoNumbersDoDoDoDo().addTwoNumbers(l1, l2);
        System.out.println(result.getVal() + "" + result.next.getVal() + "" + result.next.next.getVal());
    }

    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        int ap = 0; //进位
        while (l1 != null || l2 != null){
            ListNode node = new ListNode(ap);
            ap = 0;
            if(l1 != null){
                node.val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                node.val += l2.val;
                l2 = l2.next;
            }
            if(node.val >= 10){
                ap = 1;
                node.val = node.val % 10;
            }
            cur.next = node;
            cur = cur.next;
        }

        if(ap > 0){
            cur.next = new ListNode(1);
        }
        return preHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cr = preHead;
        int c = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                c += l1.getVal();
                l1 = l1.next;
            }

            if (l2 != null) {
                c += l2.getVal();
                l2 = l2.next;
            }

            cr.next = new ListNode(c % 10);
            cr = cr.next;
            c /= 10;
        }

        if(c > 0){
            cr.next = new ListNode(1);
        }

        return preHead.next;
    }
}

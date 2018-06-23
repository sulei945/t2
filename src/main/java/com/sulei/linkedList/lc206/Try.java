package com.sulei.linkedList.lc206;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2017/9/26.
 * 循环，递归
 */
public class Try {

    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode nextNode;
        while (head != null){
            nextNode = head.next;
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }
        return root.next;
    }

    public ListNode reverseList1(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

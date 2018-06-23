package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2018/5/23.
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        new MergeTwoSortedLists().mergeTwoLists(l1, l2);
    }

    //beats 62.5%
    public ListNode myMergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode pre = new ListNode(0);
        if(l1.val < l2.val){
            pre.next = l1;
            l1 = l1.next;
        }else {
            pre.next = l2;
            l2 = l2.next;
        }
        ListNode cur = pre.next;
        while (l1 != null || l2 != null){
            if(l1 == null){
                cur.next = l2;
                break;
            }else if(l2 == null){
                cur.next = l1;
                break;
            }else{
                if(l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else {
                    cur.next = l2;
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }
        return pre.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        } else {
            return l1 != null ? l1 : l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head;
        // First element
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else {
            head = l1 != null ? l1 : l2;
            return head;
        }
        ListNode temp = head;
        // Rest of the list
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head;
    }
}

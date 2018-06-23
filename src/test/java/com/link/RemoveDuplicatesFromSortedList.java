package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 18-5-28.
 * 删除排序链表中的重复元素
 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:
 输入: 1->1->2
 输出: 1->2

 示例 2:
 输入: 1->1->2->3->3
 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] s){

    }

    //beats 100%
    public ListNode myDeleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null){
            //注意这里是需要用while，如果用if，对于1－》1－》1的情况会输出1-》1，不能彻底过滤重复元素
            while(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}

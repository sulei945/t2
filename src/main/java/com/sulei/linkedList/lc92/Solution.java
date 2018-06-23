package com.sulei.linkedList.lc92;

import com.sulei.linkedList.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 * Created by zhangwei on 2017/9/26.
 */
public class Solution {

    /**
     * Given  1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * preNode = 1; fromNode = 2;
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preNode = head;
        for(int i=0; i<m-2; i++){
            preNode = head.next;
        }
        ListNode fromNode = preNode.next;
        ListNode curNode = fromNode.next;
        ListNode nextNode = curNode.next;
        for(int i=m; i<n; i++){

        }
        return head;
    }
}

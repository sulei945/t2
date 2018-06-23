package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2018/5/25.
 * 回文链表
 请判断一个链表是否为回文链表。
 示例 1:
 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {

    public static void main(String[] s){
        boolean r = new PalindromeLinkedList().isPalindrome1(new ListNode(1));
        System.out.print(r);
    }

    //wrong
    public boolean myIsPalindrome(ListNode head) {
        if(head == null) return false;
        String split = "-";
        StringBuilder sb = new StringBuilder(split);
        String sb2 = split;
        while (head != null){
            sb.append(head.val).append(split);
            sb2 = split + head.val + sb2;
            head = head.next;
        }
        return sb.toString().equals(sb2);
    }

    //beats 96.65%
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        boolean result = true;

        // Get size
        int size = 0;
        ListNode current = head;
        while (current != null) { current = current.next; ++size;}

        // Reverse first half
        ListNode prev = null;
        ListNode next;
        current = head;
        for (int i = 0; i < size/2; ++i) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Save middle elements
        ListNode middleL = prev;
        ListNode middleR = current;
        if (size%2 > 0) current = current.next;

        // Compare
        while (current != null) {
            if (current.val != prev.val) result = false;
            prev = prev.next;
            current = current.next;
        }

        // Restore the input data
        current = middleL;
        for (int i = 0; i < size/2; ++i) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        middleL.next = middleR;

        return result;
    }
    //beats 49.04%
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        //faster 移动速度是 slow 的两倍，faster到最后一个结点时结束，此时slow在链表中间位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        //将链表后半段反转
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //单链表反转
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

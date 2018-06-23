package com.sulei.linkedList.lc206;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2017/9/26.
 */
public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     * 反转单链表
     * 使用头插法
     *
     *  @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 头结点
        ListNode root = new ListNode(0);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }
        return root.next;
    }

    /**
     * 循环法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    /**
     * 递归法
     * 原始链表 n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
     * 递归解决了（nk+1 to nm）时 ：n1 → … → nk-1 → nk → nk+1 ← … ← nm
     * 下次递归要达到的目的 nk+1’s next node to point to nk.
     * So nk.next.next = nk;
     *
     * Be very careful that n1's next must point to Ø. If you forget about this, your linked list has a cycle in it.
     * This bug could be caught if you test your code with a linked list of size 2.
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        //空的情况和最后的节点直接返回，也是递归结束条件
        if (head == null || head.next == null){
            return head;
        }
        //递归后面的元素，直到运行到链表的最后开始返回
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 使用递归解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null||head.next== null){
            return head;
        }
        return getReverse(head, null);
    }

    /**
     * 递归
     * @param cur   对原始的列表从头到尾遍历
     * @param prev  递归过程产生的新列表
     * @return
     */
    private ListNode getReverse(ListNode cur, ListNode prev){
        //递归结束条件,走到了最后一个节点
        if(cur.next == null){
            //将最后一个节点放在第一个位置作为结果返回
            cur.next = prev;
            return cur;
        }
        //不是最后一个节点时,拿出后面的元素准备继续递归
        ListNode n1 = cur.next;
        //将当前列表的第一个元素作为新列表的头元素
        cur.next = prev;
        return getReverse(n1,cur);
    }
}

package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2018/1/1.
 * 单向链表反转
 * 给定一个链表，反转该链表从m到n的位置
 * 要求直接反转，而非申请新空间。
 * 如：   1->2->3->4->5, m=2, n=4,
 * 返回： 1->4->3->2->5.
 * 假定给出的参数 1 <= m <= n <= 链表长度
 * 当 m = 1， n = 链表长度 时为反转整个链表。
 * 如果不是反转整个链表，只需要线遍历到m结点，之前遍历到的结点不做任何处理，处理到n结点为止。
 */
public class ReverseDoDoDoDoDo {

    /**
     * 最简单到方法，时间复杂度最高
     * 假如反转整个链表：
     * 重复遍历链表，每次遍历到链表尾部时，将尾部结点摘掉，并放在链表尾部。
     */
    /**
     * 循环法,
     * 注意返回的是prev，不是cur，
     * 因为遍历到最后通过cur=null做为终止条件结束while的，即cur最后是null
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
    public ListNode reverseList2(ListNode head) {
        //空的情况和最后的节点直接返回，也是递归结束条件
        if (head == null || head.next == null){
            return head;
        }
        //递归后面的元素，直到运行到链表的最后开始返回，
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    /**
     *  线行复杂度方法 O(n):头插法，增加一个头结点root，返回的时候要注意return root.next
     *  反转整个链表时，对链表遍历一次，
     *  将当前结点摘下做为链表度头部，并将指针指向之前的头结点
     *
     * reverse a singly linked list.
     * 反转单链表
     * 使用头插法
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

}

package com.link;

import com.sulei.linkedList.ListNode;
import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangwei on 2018/1/1.
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：
 A:         a1 → a2↘
                    c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
    在节点 c1 开始相交。

 如果两个链表没有交点，返回 null.
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] s){
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);
        ListNode headB = new ListNode(2);
        new IntersectionOfTwoLinkedLists().myGetIntersectionNode(headA, headB);
    }

    //beats 100%
    public ListNode myGetIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headA;
        int al = 0;
        while (node != null){
            node = node.next;
            al++;
        }
        node = headB;
        while (node != null){
            node = node.next;
            al--;
        }
        ListNode longer = null;
        if(al < 0){
            al = al * (-1);
            node = headA;
            longer = headB;
        }else {
            node = headB;
            longer = headA;
        }
        while (al > 0){
            longer = longer.next;
            al--;
        }
        while (longer != null){
            if(node == longer) return node;
            node = node.next;
            longer = longer.next;
        }
        return null;
    }

    //beats 2.4%
    public ListNode myGetIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode a = headA;
        while (a != null){
            set.add(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null){
            if(set.contains(b)){
                return b;
            }
            b = b.next;
        }
        return null;
    }

    //????
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }



    /**
     * 链表相交，那结果是相交后就不会分开了。
     * 即链表是Y状而不是X状。
     * 先将连个链表长度算出，去掉长的链表前面的结点，找到对应短链表的第一个结点位置。
     * 然后同步向后走，比较结点是不重合，没重合各往后走一步，直到找到或者遍历结束为止。
     *
     * 如果链表可能是有环的，那就让一个链表遍历的快，一个慢，如果有交点快的肯定能追上慢的。
     * //todo 有问题，获取length的时候已经破坏了原链表，需要保留源链表的头指针
     */
    public static DataNode getFirstJoinNode(DataNode h1,DataNode h2) {
        int length1 = 0;
        int length2 = 0;
        while(null != h1.getNext()) {
            length1 ++;
            h1 = h1.getNext();
        }
        while(null != h2.getNext()) {
            length1 ++;
            h2 = h2.getNext();
        }

        int diff = length1 - length2;
        boolean h2Longer = false;
        if(diff < 0){
            diff = -diff;
            h2Longer = true;
        }
        if(h2Longer){
            DataNode temp = h1;
            h1 = h2;
            h2 = temp;
        }
        while (diff > 0){
            h1 = h1.getNext();
        }
        while (h1 != h2){
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return h1;
    }


    class DataNode{

        private int data;
        private DataNode next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DataNode getNext() {
            return next;
        }

        public void setNext(DataNode next) {
            this.next = next;
        }

        public DataNode(int data) {
            this.data = data;
        }

    }
}

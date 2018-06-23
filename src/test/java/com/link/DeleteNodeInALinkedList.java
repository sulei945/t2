package com.link;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 2018/5/25.
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。

 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，
 那么在调用了您的函数之后， 该链表则应变成 1 -> 2 -> 4 。
 */
public class DeleteNodeInALinkedList {

    //beats 60.37% 只要将node的当前值赋值成下一个，当前的next指针指向下下个node即可
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

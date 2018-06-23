package com.link;

import com.sulei.linkedList.ListNode;
import com.utils.ArrayToListNode;

/**
 * Created by zhangwei on 2018/5/29.
 * 删除链表中的节点
 * 删除链表中等于给定值 val 的所有节点。

 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5

 */
public class RemoveLinkedListElements {

    public static void main(String[] s){
        ListNode node = ArrayToListNode.arraysToListNode(new int[]{1,2,6,4,5,6});
        new RemoveLinkedListElements().removeElements(node, 6);
    }

    //beats 100%
    public ListNode myRemoveElements(ListNode head, int val) {
        if(head == null) return head;

        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return head;

        ListNode node = head;
        while (node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        if(node.val == val){
            node = null;
        }
        return head;
    }

    //beats 10.6%
    public ListNode myRemoveElements1(ListNode head, int val) {
        if(head == null) return head;

        while (head != null && head.val == val){
            head = head.next;
        }

        ListNode node = head;
        while (node != null){
            if(node.next == null){
                if(node.val == val){
                    node = null;
                    break;
                }else{
                    node = node.next;
                }
            }else if(node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {

        // the last one
        if(null == head) return null;

        head.next = removeElements(head.next, val);

        return (head.val == val) ? head.next : head;
    }




}
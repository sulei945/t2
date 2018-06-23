package com.link;

import com.sulei.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangwei on 2018/4/27.
 */
//Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?
//找出linked list是否有环， 能否不用额外空间搞定？
public class LinkedListCycle {

    //beats 25%
    public boolean hasCycle(ListNode head) {
        //空或只有一个结点
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //只有一个结点的环
        if(slow == fast){
            return true;
        }
        slow = fast;
        fast = fast.next;

        //每次循环fast都比slow多走一步，如果有环fast会追上slow
        while (fast != null){
            //fast和slow重合了，说明有环
            if(slow == fast){
                return true;
            }
            //slow == head 说明slow又走到head了，即head在环上
            if(slow == head){
                return true;
            }

            //fast往后走一步看一下情况
            fast = fast.next;
            if(fast == null){
                return false;
            }
            if(slow == fast){
                return true;
            }

            //slow,head 各走一步
            slow = slow.next;
            fast = fast.next;
        }

        //fast == null 跳出循环说明fast走到链表尾部，说明没有环
        return false;
    }

    //beats 94,44%
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head == null)
            return false;

        if(head.next == null)
            return false;

        while(fast != null && fast.next != null){   //防止下面faster走两步时出现null情况，需要多判断一步null
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }

    public boolean hasCycle3(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<ListNode>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}

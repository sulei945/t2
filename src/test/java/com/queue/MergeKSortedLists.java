package com.queue;

import com.sulei.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhangwei on 2018/5/2.
 */
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//将k个已排好序的链表合并为一个非下降排序的链表。
    //todo 验证？
public class MergeKSortedLists {



    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        //不是必须的，主要是想让低版本低jdk正常编译，PriorityQueue的构造方法低版本需要指定initialCapacity
        int nums = 0;
        for(ListNode ln:lists){
            while (ln != null){
                nums++;
                ln = ln.next;
            }
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(nums, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });




        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) minHeap.offer(lists[i]);
        }

        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            head.next = min;
            head = head.next;
            if(min.next != null){
                minHeap.offer(min.next);
                min = min.next;
            }
        }
        return dummy.next;
    }

}

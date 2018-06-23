package com.utils;

import com.sulei.linkedList.ListNode;

/**
 * Created by zhangwei on 18-5-29.
 */
public class ArrayToListNode {

    public static ListNode arraysToListNode(int[] nums){
        ListNode result = new ListNode(nums[0]);
        ListNode node = result;
        for(int i=1; i<nums.length; i++){
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return result;
    }
}

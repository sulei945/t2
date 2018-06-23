package com.sulei.linkedList;

/**
 * Created by zhangwei on 2017/9/26.
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public String str;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(String str) { this.str = str; }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

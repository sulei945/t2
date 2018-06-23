package com.design;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/25.
 * 最小栈
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。

 */
public class MinStack {
    public static void main(String[] s){
        MinStack ms = new MinStack();
        ms.push(-1);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
    /** initialize your data structure here. */
    //beats 69.54%
    public MinStack() {

    }

    public void push(int x) {
        queue.offer(x);
        priorityQueue.offer(x);
    }

    public void pop() {
        int x = queue.removeLast();
        priorityQueue.remove(x);
    }

    public int top() {
        return queue.getLast();
    }

    public int getMin() {
        return priorityQueue.peek();
    }

}

//beats 44.37%
class MinStack2 {
    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

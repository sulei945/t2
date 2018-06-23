package com.tree;

import com.link.DoublePointLinkNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangwei on 2018/5/15.
 * 求搜索二叉树中最小（任意）两结点差值
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] s) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(6);

        MinimumDistanceBetweenBSTNodes obj = new MinimumDistanceBetweenBSTNodes();
        obj.Convert(node);
        obj.findMin();
    }


    private TreeNode head=null;
    private TreeNode tail=null;
    private TreeNode Convert(TreeNode pRootOfTree) {
        visit(pRootOfTree);
        return head;
    }
    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }

        //这么递归执行顺序就是从小到大！！！！！！！！！！！！！！！！
        visit(root.left);   //递归到最左边节点，即最小元素
        createList(root);   //第一次执行create的root是最小元素
        visit(root.right);
    }

    private void createList(TreeNode cur){
        cur.left=tail;//把当前的节点接到链表的尾部
        if(tail!=null){//双向连接
            tail.right=cur;
        }else{
            head=cur;
        }
        tail=cur;//更新尾结点为当前结点，或者说：尾结点后移
    }

    private int findMin(){
        TreeNode node = head;
        int min = Integer.MAX_VALUE;
        while (node.right != null){
            if(node.right.val - node.val < min){
                min = node.right.val - node.val;
            }
            node = node.right;
        }
        return min;
    }





    //这个是相邻两结点的差值
    public int minDiffInBST2(TreeNode root){
        if(root == null) return -1;
        return minDiffInBST(root, Integer.MAX_VALUE);
    }

    private int minDiffInBST(TreeNode root, int min) {
        if(root.left != null){
            if(root.val - root.left.val < min){
                min = root.val - root.left.val;
            }
            min = minDiffInBST(root.left, min);
        }
        if(root.right != null){
            if(root.right.val - root.val < min){
                min = root.right.val - root.val;
            }
            min = minDiffInBST(root.right, min);
        }
        return min;
    }


    //====================================下面的有问题===============================

    public int minDiffInBST(TreeNode root){
        DoublePointLinkNode linkNode = treeToList(root, null);

        return 0;
    }

    private DoublePointLinkNode treeToList(TreeNode root, DoublePointLinkNode link){
        if(root != null){
            link = new DoublePointLinkNode(root.val);
        }
        if(root.left != null){
            link.pre = treeToList(root.left, link.pre);
        }
        if(root.right != null){
            link.next = treeToList(root.right, link.next);
        }
        return link;
    }




}

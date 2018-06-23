package com.tree;

/**
 * Created by zhangwei on 2018/5/17.
 * 判断两个二叉树是否相等
 * 如果结构相同且每个结点上的值也相等则相同
 */
public class SameTree {

    public static void main(String[] s){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        new SameTree().isSameTree(p, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if((p == null || q == null) && p != q) return false;

        if(p.val != q.val) return false;
        boolean lr = isSameTree(p.left, q.left);
        if(!lr) return false;
        boolean rr = isSameTree(p.right, q.right);
        if(!rr) return false;
        return true;
    }

}

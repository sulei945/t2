package com.tree;

/**
 * Created by zhangwei on 2018/4/17.
 * 判断一棵树是否是BST(二叉查询树)
 */
public class IsBST {


    //要判断是否是二叉查询树，标准就是看每一个节点是否满足：
    // 1、左节点及以下节点的值比它小；2、右节点及以下节点的值比它大。
    private boolean isBST(TreeNode node) {
        if(node == null) return true;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left != null && node.val < left.val){
            return false;
        }
        if(right != null && node.val > right.val){
            return false;
        }
        return isBST(left) && isBST(right);
    }



}

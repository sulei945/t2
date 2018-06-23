package com.tree;

import com.utils.ArraysToTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 18-5-29.
 路径总和
 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {

    public static void main(String[] s){
//        Integer[] nums = new Integer[]{1,2,null,3,null,4,null,5}; 6

        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ArraysToTreeNode.arraysToTreeNode(nums);
        boolean r = new PathSum().hasPathSum(root, 22);
        System.out.println("ok");
    }

    private boolean result = false;
    //beats 50%
    public boolean myHasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        if(root.left != null){
            doSum(root.left, sum, root.val);
            if(result) return true;
        }
        if(root.right != null){
            doSum(root.right, sum, root.val);
            if(result) return true;
        }
        return false;
    }

    private boolean doSum(TreeNode node, int sum, int cur){
        if(result) return true;
        if(node == null ){
            if( sum == cur){
                return true;
            }else {
                return false;
            }
        }

        cur += node.val;
        boolean l = doSum(node.left, sum, cur);
        boolean r = doSum(node.right, sum, cur);
        if(l && r){
            result = true;
        }
        return  l && r;
    }

    //beats 50%
    public boolean hasPathSum(TreeNode root, int sum) {
        //处理跟结点
        if (root == null)
            return false;

        //找到符合条件的叶子结点
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        //左右路径有一个找到即存在
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }


}

package com.tree;

import java.util.*;

/**
 * Created by zhangwei on 18-5-28.
 * 二叉树的层次遍历 II
 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],
   3
  / \
 9  20
   /  \
  15   7
 返回其自底向上的层次遍历为：
 [
    [15,7],
    [9,20],
     [3]
 ]
 */
public class BinaryTreeLevelOrderTraversalII {

    //beats 86.29%
    public List<List<Integer>> myLevelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> llr = new LinkedList<List<Integer>>();
        list.add(root);
        while (!list.isEmpty()){
            int size = list.size();
            List<Integer> rl = new ArrayList<Integer>(size);
            llr.offer(rl);
            for (int i=0; i<size; i++){
                TreeNode tn = list.poll();
                rl.add(tn.val);
                if(tn.left != null){
                    list.offer(tn.left);
                }
                if(tn.right != null){
                    list.offer(tn.right);
                }
            }
        }
        while (!llr.isEmpty()){
            result.add(llr.removeLast());
        }
        return result;
    }

    //return List<List<Integer>>, 可以是LinkedList<ArrayList<>>
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        LinkedList<List<Integer>> traversals = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int numNodesAtLevel = queue.size();
            List<Integer> levelTraversal = new ArrayList<Integer>();
            for (int i = 0; i < numNodesAtLevel; i++) {
                TreeNode node = queue.poll();
                levelTraversal.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            traversals.addFirst(levelTraversal);
        }

        return traversals;
    }
}

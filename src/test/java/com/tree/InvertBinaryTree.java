package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/14.
 * input
      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 output
      4
    /   \
   7     2
  / \   / \
 9   6 3   1

 反转二叉树
 */
public class InvertBinaryTree {


    public TreeNode myInvertTree(TreeNode root) {
        if(root== null) return null;
        doIT(root);
        return root;
    }

    private void doIT(TreeNode node){
        TreeNode tn = node.left;
        node.left = node.right;
        node.right = tn;
        if(node.left != null){
            doIT(node.left);
        }
        if(node.right != null){
            doIT(node.right);
        }
    }


    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree1(root.right);
        TreeNode left = invertTree1(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public TreeNode invertTree3(TreeNode root){
        if (root == null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree3(root.left);
        invertTree3(root.right);

        return root;
    }
}

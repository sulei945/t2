package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/21.
 * 找出二叉树最浅叶子结点的深度

 Given binary tree [3,9,20,null,null,15,7],
   3
  / \
 9  20
   /  \
  15   7
 return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {


    //beats 99.67%
    public int myMinDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root.left != null){
            queue.add(root.left);
        }
        if(root.right != null){
            queue.add(root.right);
        }
        int level = 2;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return level;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }

    private int minLevel = Integer.MAX_VALUE;
    //beats 99.67%
    public int myMinDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        if(root.left != null)
            minDepth(root.left, 2);
        if(root.right != null)
            minDepth(root.right, 2);

        return minLevel;
    }

    private void minDepth(TreeNode root, int level){
        if(root.left == null && root.right == null) {
            if(level < minLevel){
                minLevel = level;
            }
            return ;
        }

        level++;

        if(root.left != null){
            minDepth(root.left, level);
        }
        if(root.right != null){
            minDepth(root.right, level);
        }
    }


    //beats 99.67%
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    //beats 99.67%, 同my
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return level;
    }
}

package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/24.
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。
 */
public class MaximumDepthOfABinaryTree {

    //beats 100%
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //beats 8.13%
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int r = 0;
        while (!queue.isEmpty()){
            r++;
            int s = queue.size();
            while (s > 0){
                TreeNode n = queue.poll();
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
                s--;
            }
        }
        return r;
    }

}

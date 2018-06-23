package com.utils;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 18-5-29.
 */
public class ArraysToTreeNode {

    public static TreeNode arraysToTreeNode(Integer[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i<nums.length){
            TreeNode node = queue.poll();
            Integer x = nums[i++];
            if(x != null){
                node.left = new TreeNode(x);
                queue.offer(node.left);
            }

            if(i<nums.length){
                x = nums[i++];
                if(x != null){
                    node.right = new TreeNode(x);
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}

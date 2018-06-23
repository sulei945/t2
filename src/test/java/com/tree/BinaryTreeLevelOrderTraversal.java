package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/4/20.
 */
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] s){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = new BinaryTreeLevelOrderTraversal().mySolution(root);

        for(List<Integer> l:result){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> mySolution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        visit(result, root, 0);
        return  result;
    }

    private void visit(List<List<Integer>> result, TreeNode node, int level){
        if(node != null){
            while (result.size() <= level){
                List<Integer> list = new ArrayList<Integer>();
                result.add(list);
            }
            List<Integer> list = result.get(level);
            list.add(node.val);
            level++;
            visit(result, node.left, level);
            visit(result, node.right, level);
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(root.val);
        result.add(tempList);

        while(!queue.isEmpty()) {
            Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();

            List<Integer> list = new ArrayList<Integer>();

            while(!queue.isEmpty()) {
                TreeNode current = queue.remove();

                if(current.left != null) {
                    currentLevel.add(current.left);
                    list.add(current.left.val);
                }

                if(current.right != null) {
                    currentLevel.add(current.right);
                    list.add(current.right.val);
                }
            }

            if(list.size() > 0) {
                result.add(list);
            }

            queue = currentLevel;
        }

        return result;
    }

}

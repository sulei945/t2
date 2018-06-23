package com.tree;

import com.arrays.ThirdMaximumNumber;

/**
 * Created by zhangwei on 2018/5/24.
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

    0
   / \
 -3   9
 /   /
 -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] s){
        new ConvertSortedArrayToBinarySearchTree().mySortedArrayToBST(new int[]{1, 3});
    }

    //wrong
    public TreeNode mySortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        doSort(nums, root, 0, mid, true);
        doSort(nums, root, mid+1, nums.length-1, false);
        return root;
    }

    private void doSort(int[] nums, TreeNode node, int f, int t, boolean left){
        if(f>t) return;
        if(f == t){
            if(left)
                node.left = new TreeNode(nums[f]);
            else
                node.right = new TreeNode(nums[f]);
            return;
        }
        int mid = (f+t)/2;
        TreeNode temp = new TreeNode(nums[mid]);
        if(left){
            node.left = temp;
        }else{
            node.right = temp;
        }
        doSort(nums, temp, f, mid-1, true);
        doSort(nums, temp, mid+1, t, false);
    }


    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

}

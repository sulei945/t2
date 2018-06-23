package com.arrays;

import com.tree.TreeNode;

/**
 * Created by zhangwei on 2018/4/17.
 */
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//将排序数组转换为平衡二叉搜索树

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] s){
        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8});

        new ConvertSortedArrayToBinarySearchTree().mySortedArrayToBST(new int[]{1,2,3,4,5,6,7,8});
    }

    public TreeNode mySortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int m = (nums.length-1)/2;
        TreeNode root = new TreeNode(nums[m]);
        helper(nums,root, 0, m-1, true);
        helper(nums,root, m+1, nums.length-1, false);
        return root;
    }

    private void helper(int[] nums, TreeNode tn, int start, int end, boolean isLeft){
        if(start > end || tn == null){
            return;
        }
        int m = (start + end) / 2;
        TreeNode ntn = new TreeNode(nums[m]);
        if(isLeft){
            tn.left = ntn;
        }else {
            tn.right = ntn;
        }
        helper(nums, ntn, start, m-1, true);
        helper(nums, ntn, m+1, end, false);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        //将数组不断切成小数组，转成确定树的根结点后不断建立子树的过程
        TreeNode root = helper(nums, 0, nums.length - 1);

        return root;
    }


    private TreeNode helper(int[] nums, int start, int end) {
        //正常时找到中间值并对他创建节点并返回，将中间结点分成左右两个小规模数据递归操作，分别挂在左右子结点上
        if(start <= end) {
            //对数组进行转化时，找到中间结点位置
            int mid = (start + end) / 2;
            //将中间结点转成Node
            TreeNode current = new TreeNode(nums[mid]);
            //递归切成更小的单元
            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);

            return current;
        }
        //终止时，返回null做结点的子结点
        return null;
    }


}

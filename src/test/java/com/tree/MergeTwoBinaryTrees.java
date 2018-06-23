package com.tree;

import com.link.MergeTwoSortedLists;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangwei on 2018/5/28.
 * 合并二叉树
 *
 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

 示例 1:
 输入:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 输出:
 合并后的树:
 3
 / \
 4   5
 / \   \
 5   4   7
 注意: 合并必须从两个树的根节点开始。
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] s){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        new MergeTwoBinaryTrees().myMergeTrees(t1, t2);
    }

    //beats 73.33%
    public TreeNode myMergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        TreeNode result = new TreeNode(0);
        doMerge(result, t1, t2);
        return result;
    }

    private TreeNode doMerge(TreeNode r, TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            r = null;
        }else if(t1 != null && t2 != null){
            r.val = t1.val + t2.val;
            r.left = new TreeNode(0);
            r.right = new TreeNode(0);
            r.left = doMerge(r.left, t1.left, t2.left);
            r.right = doMerge(r.right, t1.right, t2.right);
        }else if(t1 == null){
            r = t2;
        }else {
            r = t1;
        }
        return r;
    }

    //wrong
    public TreeNode myMergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        TreeNode r = new TreeNode(t1.val + t2.val);
        Queue<TreeNode[]> queue = new LinkedList<TreeNode[]>();
        if(t1.left != null || t2.left != null){
            r.left = new TreeNode(0);
            queue.offer(new TreeNode[]{t1.left, t2.left, r.left});
        }
        if(t1.right != null || t2.right != null){
            r.right = new TreeNode(0);
            queue.offer(new TreeNode[]{t1.right, t2.right, r.right});
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode[] tn = queue.poll();
                if(tn[0] == null){
                    tn[2] = tn[1];
                    break;
                }else if(tn[1] == null){
                    tn[2] = tn[0];
                    break;
                }else{
                    tn[2] = new TreeNode(tn[0].val + tn[1].val);
                    if(tn[0].left != null || tn[1].left != null){
                        tn[2].left = new TreeNode(0);
                        queue.offer(new TreeNode[]{tn[0].left, tn[1].left, tn[2].left});
                    }
                    if(tn[0].right != null || tn[1].right != null){
                        tn[2].right = new TreeNode(0);
                        queue.offer(new TreeNode[]{tn[0].right, tn[1].right, tn[2].right});
                    }
                }
            }

        }
        return r;
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack< TreeNode[] > stack = new Stack < TreeNode[] > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/24.
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricTree {

    public static void main(String[] s){
        System.out.println(true || false);
        System.out.println(true || true);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        new SymmetricTree().isSymmetric(root);
    }

    //beats 81.83%
    public boolean myIsSymmetric(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root.left != null)
            queue.add(root.left);
        if(root.right != null)
            queue.add(root.right);
        if(queue.size() == 1) return false;
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                TreeNode hn = queue.removeFirst();
                TreeNode tn = queue.removeFirst();
                if(hn.val != tn.val) return false;
                if(hn.left == null && tn.right != null) return false;
                if(hn.right == null && tn.left != null) return false;
                if(tn.left == null && hn.right != null) return false;
                if(tn.right == null && hn.left != null) return false;
                if(hn.left != null)
                    queue2.offer(hn.left);
                if(tn.right != null)
                    queue2.offer(tn.right);
                if(hn.right != null) {
                    queue2.offer(hn.right);
                }
                if(tn.left != null) {
                    queue2.offer(tn.left);
                }
            }
            LinkedList temp = queue;
            queue = queue2;
            queue2 = temp;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}

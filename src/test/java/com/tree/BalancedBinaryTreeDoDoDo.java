package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/17.
    给定一棵二叉树，确定它是否是高度平衡的。
    对于这个问题，高度平衡二叉树定义为：
    一种二叉树，其中每个节点的两个子树的深度永远不超过1。
 */
public class BalancedBinaryTreeDoDoDo {
    public static void main(String[] s){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.left.left.left.left = new TreeNode(6);
        root.left.left.left.right = new TreeNode(6);
        new BalancedBinaryTreeDoDoDo().myIsBalanced(root);
    }

    //-------------------------------------------------
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }
    //-------------------------------------------------


    public boolean myIsBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        initSmallDep(root);

        boolean r = find(root);
        return r;
//        boolean l = doIB(root.left, 1);
//        if(!l) return false;
//        boolean r = doIB(root.right, 1);
//        if(!r) return false;
//        return true;
    }

    int smallDep = 1;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    private void initSmallDep(TreeNode root){
        queue.offer(root.left);
        queue.offer(root.right);
        for(;;smallDep++){
            int qs = queue.size();      //循环次数是：queue里循环前拥有的元素数
            for(int i=0; i<qs; i++){
                TreeNode n = queue.poll();
                if(n == null){
                    return;
                }else {
                    queue.offer(n.left);
                    queue.offer(n.right);
                }
            }
        }
    }

    private boolean find(TreeNode root){
        queue.clear();
        queue.offer(root.left);
        queue.offer(root.right);
        int dep = 1;
        for(;!queue.isEmpty();dep++){
            int qs = queue.size();
            for(int i=0; i<qs; i++){
                TreeNode n = queue.poll();
                if(n == null){
                    if(dep > smallDep+1){
                        return false;
                    }
                }else {
                    queue.offer(n.left);
                    queue.offer(n.right);
                }
            }
        }
        return true;
    }


    private boolean doIB(TreeNode root, int dep){
        if(root == null){
            if(dep>smallDep+1)
                return false;
            return true;
        }
        dep++;
        boolean lr = doIB(root.left, dep);
        if(!lr) return false;
        boolean rr = doIB(root.right, dep);
        if(!rr) return false;
        return true;
    }
}

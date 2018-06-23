package com.tree;

import com.link.DoublePointLinkNode;

/**
 * Created by zhangwei on 2018/4/17.
 * 二分查找树，转成双向链表
 */
public class BTSToLinkListDoDoDoDoDoDo {

    public static void main(String[] s){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(6);

        DoublePointLinkNode linkNode =  new BTSToLinkListDoDoDoDoDoDo().mySolution(node);
        DoublePointLinkNode headNode = null;
        while (linkNode != null){
            System.out.print(linkNode.val);
            linkNode = linkNode.pre;

            if(linkNode != null){
                headNode = linkNode;
            }
        }
        System.out.println();
        while (headNode != null){
            System.out.print(headNode.val);
            headNode = headNode.next;
        }

        new BTSToLinkListDoDoDoDoDoDo().Convert(node);
    }

    private DoublePointLinkNode myTail = null;    //通过保存最后的结点找到链表尾部


    //用中序遍历的方式递归得出
    private DoublePointLinkNode mySolution(TreeNode node){
        if(node == null) return null;

        DoublePointLinkNode linkNode = new DoublePointLinkNode(node.val);
        helper(node, linkNode);
        return myTail;
    }

    private void helper(TreeNode treeNode, DoublePointLinkNode linkNode){
        if(treeNode == null){
            return;
        }
        //处理左枝
        TreeNode left = treeNode.left;
        if(left != null){
            DoublePointLinkNode temp = linkNode.pre;   //缓存之前链表的结点

            //创建相应都链表结点，左边都比根要小，需要插入在前面
            linkNode.pre = new DoublePointLinkNode(left.val);
            linkNode.pre.next = linkNode;   //双向链表

            if(temp != null){   //补全双向链表
                temp.next = linkNode.pre;
                linkNode.pre.pre = temp;
            }
        }

        TreeNode right = treeNode.right;
        if(right != null){
            DoublePointLinkNode temp = linkNode.next;

            linkNode.next = new DoublePointLinkNode(right.val);
            linkNode.next.pre = linkNode;

            if(temp != null){
                temp.pre = linkNode.next;
                linkNode.next.next = temp;
            }
            myTail = linkNode.next;
        }

        if(left != null){
            helper(left, linkNode.pre);
        }
        if(right != null){
            helper(right, linkNode.next);
        }
    }


    private TreeNode head=null;
    private TreeNode tail=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        visit(pRootOfTree);
        return head;
    }
    public void visit(TreeNode root) {
        if (root == null) {
            return;
        }

        //这么递归执行顺序就是从小到大！！！！！！！！！！！！！！！！
        visit(root.left);   //递归到最左边节点，即最小元素
        createList(root);   //第一次执行create的root是最小元素
        visit(root.right);
    }

    public void createList(TreeNode cur){
        cur.left=tail;//把当前的节点接到链表的尾部
        if(tail!=null){//双向连接
            tail.right=cur;
        }else{
            head=cur;
        }
        tail=cur;//更新尾结点为当前结点，或者说：尾结点后移
    }
}

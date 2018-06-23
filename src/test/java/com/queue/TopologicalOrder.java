package com.queue;

/**
 * Created by zhangwei on 2018/1/1.
 * 拓扑排序
 * 对一个有向无环图(Directed Acyclic Graph简称DAG)G进行拓扑排序，
 * 是将G中所有顶点排成一个线性序列，使得图中任意一对顶点u和v，若边(u,v)∈E(G)，则u在线性序列中出现在v之前。
 * 通常，这样的线性序列称为满足拓扑次序(Topological Order)的序列，简称拓扑序列。
 * 简单的说，由某个集合上的一个偏序得到该集合上的一个全序，这个操作称之为拓扑排序。
 */
public class TopologicalOrder {

    /**
     * 首先列出所有结点的入度数，摘掉并输出入读数为0的结点。
     * 摘掉结点的同时更新入度数，因为每摘掉一个结点，就有相应的结点的入读数需要-1，
     * 再次列出所有结点的入读数，摘掉并输出入读数为0的结点...不断重复以上过程
     * 直到结束，如果发现某次所有的结点的入度数都大于0，则说明图存在环。
     */
}
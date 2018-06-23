package com.divideAndConquer;

/**
 * Created by zhangwei on 2018/1/7.
 * 计算围棋中的正方形数量
 * 围棋棋盘由横纵19*19条先组成，请问这些线一共组成多少个正方形？
 * 假定只考虑横纵方向，忽略倾斜方向。
 *
 */
public class NumberOfSquares {
    public static void main(String[] a){
        System.out.println(min());
    }

    /**
     * 动态规划方法，将大问题分解成小问题：
     * 假设每个横纵交点的位置为（i，j）其中，左上角的点为（0，0），右下角的点为（19，19）
     * f(i,j) 为以(i,j)为右下角的正方形数目。
     * f(i,j) = f(i,j-1), i<j . 在棋盘上横移，可得
     * f(i,j) = f(i-1,j), i>j . 在棋盘上纵移，可得
     * 因此 f(i,j) = max(f(i,j-1), f(i-1,j)), i!=j
     *     f(i,j) = f(i-1,j)+1, i=j
     */




    /**
     * 实际上：f(i,j)=min(i,j)
     *  如边上的线为右下角的正方形都是0，f(i,0) = min(i,0)=0, f(0,j)=min(0,j)=0
     *  第二行都有一个，即 f(1,j)=min(1,j)= 0(j=0) / 1(j!=0)
     *  以此类推就有f(i,j)=min(i,j)
     */
    private static int min(){
        int m=19;
        int n=19;
        int count =0;
        int i, j;
        for(i = 1; i<m; i++){
            for (j = 1; j<n; j++){
                count += Math.min(i, j);
            }
        }
        return count;
    }

    /**
     * 直接计算：
     * 数一下边长是1,2,3...,18的正方形各有多少各，能得到：
     * count = 1的平方 + 2的平方 + ... + 18的平方
     * 高中的知识可以计算出结果
     */

}

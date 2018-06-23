package com.dp;

/**
 * Created by zhangwei on 2018/5/21.

 你正在爬楼梯。它需要N个台阶才能到达顶端。
 每次你可以爬1或2步。你能爬到山顶多少种不同的方式？

 注：给定n为正整数。
 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    /**
     * 从1～n计算每一种台阶有多少中走法
     * 1层时：1种
     * 2层时：2种
     * 最后一层（第N层）的走法有两种情况
     * A：一步迈上去的，这种方式和N-1层的方式数量相同
     * B：两步迈上去的，这种方式和N-2层的方式数量相同
     * 所以N层的方式即（N-1），（N-2）层的方式之和相同
     */
    //beats 98.62%
    public int climbStairs(int n) {
        int preTwo = 1; //初始化为1层
        int pre = 2;    //初始化为2层
        if(n == 1) return preTwo;
        if (n == 2) return pre;
        int result = 0;
        for(int i=3; i<=n; i++){
            result = preTwo + pre;
            preTwo = pre;
            pre = result;
        }
        return result;
    }

}

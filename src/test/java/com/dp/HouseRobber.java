package com.dp;

/**
 * Created by zhangwei on 2018/4/17.
 */
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

//一条直线上有n座房子，每座房子里都有一定的现金（用nums[i]表示），不能同时抢劫相邻的两座房子，问最多能抢劫多少钱？
public class HouseRobber {

    // O(n)空间的写法
    public int rob1(int[] num) {
        if (num.length == 0) return 0;

        int[] dp = new int[num.length + 1];
        dp[0] = 0;
        dp[1] = num[0];

        for (int i = 2; i <= num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i - 1]);
        }

        return dp[num.length];
    }

    // O(1)空间的写法,只需要保存2个数组，后面不断覆盖前面的即可
    public int rob(int[] num) {
        if (num.length == 0) return 0;
        int prepre = 0;
        int pre = num[0];
        for (int i = 1; i < num.length; i++) {
            int cur = Math.max(prepre + num[i], pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}

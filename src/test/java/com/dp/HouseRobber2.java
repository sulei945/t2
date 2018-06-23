package com.dp;

/**
 * Created by zhangwei on 2018/4/17.
 */
//一个圆上有n座房子，其它条件都一样(HouseRobber)，
// 只是第1座房子和第n座房子变成相邻的了，也就是说不能同时抢了，
// 那么最优解就变成 第1座房子到第n-1座房子能抢的最多的钱 或者 第2座房子到第n座房子能抢的钱了。
public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robBetween(nums, 0, n - 2), robBetween(nums, 1, n - 1));
    }

    public int robBetween(int[] nums, int start, int end) {
        int prepre = 0;
        int pre = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int cur = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}

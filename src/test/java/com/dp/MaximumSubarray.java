package com.dp;

/**
 * Created by zhangwei on 2018/5/16.
 * 最大子序和:找出最大连续和的值
 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public int myMaxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > 0){
                nums[i] = nums[i] + nums[i-1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i > max){
                max = i;
            }
        }
        return max;
    }


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}

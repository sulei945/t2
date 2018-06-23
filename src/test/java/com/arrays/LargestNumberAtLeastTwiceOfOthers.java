package com.arrays;

/**
 * Created by zhangwei on 2018/5/15.
 * 整数数组中最大元素是否至少是其它元素的2倍
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int myDominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int mi = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                secMax = max;
                max = nums[i];
                mi = i;
            }else if(nums[i]>secMax){
                secMax = nums[i];
            }
        }

        return max>=(secMax+secMax)?mi:-1;
    }
}

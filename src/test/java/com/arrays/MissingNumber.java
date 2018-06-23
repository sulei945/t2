package com.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangwei on 2018/5/25.
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

 示例 1:
 输入: [3,0,1]
 输出: 2

 示例 2:
 输入: [9,6,4,2,3,5,7,0,1]
 输出: 8
 说明:
 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {

    //beats 92.68%
    public int myMissingNumber(int[] nums) {
        int s = nums.length;
        int[] temp = new int[s+1];
        for(int i:nums){
            temp[i] = 1;
        }
        for(int r=0; r<temp.length; r++){
            if(temp[r] == 0){
                return r;
            }
        }
        return 0;
    }
    //beats 22.56%
    public int myMissingNumber2(int[] nums) {
        Arrays.sort(nums);
        int x = 0;
        for(int i=0; i<nums.length; i++,x++){
            if(nums[i] != x){
                return x;
            }
        }
        return nums[nums.length-1]+1;
    }

    //beats 5.49%
    public int myMissingNumber3(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    //厉害：总和的方式
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    //厉害：位操作
    public int missingNumber1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

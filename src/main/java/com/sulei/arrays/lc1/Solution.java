package com.sulei.arrays.lc1;

import java.util.HashMap;

/**
 * Created by zhangwei on 2018/1/24.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Solution {
    public static void main(String[] s){
        int[] nums = {0,1,0};
        twoSum(nums, 0);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++){
            int v = nums[i];
            if(map.containsKey(v)){
                result[0] = map.get(v);
                result[1] = i;
                break;
            }
            map.put(target-v, i);
        }
        return result;
    }
}

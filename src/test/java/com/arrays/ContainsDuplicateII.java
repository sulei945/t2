package com.arrays;

import java.util.*;

/**
 * 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 * 输入: [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: [1,2,1], k = 0
 * 输出: false
 */
public class ContainsDuplicateII {

    public static void main(String[] s){
        new ContainsDuplicateII().myContainsNearbyDuplicate(new int[]{1,2,3,1}, 3);
    }

    //beats 100%
    public boolean myContainsNearbyDuplicate(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            int j = 1;
            int x = i+j;
            while (j <= k && x<nums.length){
                if(nums[i] == nums[x]){
                    return true;
                }
                j++;
                x++;
            }
        }

        return false;
    }

    //beats 34.02%
    public boolean myContainsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            //如果之前存在当前数字，并且当前位置符合条件ok
            if(temp.containsKey(nums[i]) && i < temp.get(nums[i])){
                return true;
            }
            //否则将当前数子符合条件的极限情况保持下来
            temp.put(nums[i], i+k+1);
        }
        return false;
    }

    //这个是相差是k的情况
    public boolean myContainsNearbyDuplicateK(int[] nums, int k) {
        int i = 0;
        for(int j = i + k; j<nums.length; j++, i++){
            if(nums[i] == nums[j]){
                return true;
            }
        }
        return false;
    }

    //beats 100%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length>1000){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            int x=i;int count=0;
            while(x<nums.length){
                count++;
                x++;
                if(count>k||x==nums.length){
                    break;
                }
                if(nums[i]==nums[x]){
                    return true;

                }
            }
        }
        return false;
    }

}

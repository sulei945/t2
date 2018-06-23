package com.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhangwei on 2018/4/16.
 * 判断是否有重复的数
 */
//Given an array of integers, find if the array contains any duplicates. Your function should return
//true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3}));
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,2}));

        new ContainsDuplicate().test(new int[]{1,2,2});
        //new ContainsDuplicate().test(new int[]{1,2,2});
    }

    //beats 44.92% 时间复杂度O(N),空间复杂度也是O(N)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums) {
            if(map.containsKey(i)) {
                return true;
            } else {
                map.put(i, 1);
            }
        }

        return false;
    }

    //beats 74.91%
    public boolean containsDuplicate2(int[] nums) {
        if(nums == null || nums.length<2) return false;
        Arrays.sort(nums);
        int m = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == m){
                return true;
            }
            m = nums[i];
        }
        return false;
    }

    public boolean containsDuplicate22(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    //??, 根据a^b^b=a
    public void test(int[] nums){
        int c = 0;
        int pc = 0;
        int pc2= 0;
        for(int i: nums){
            pc = c;
            c^=i;
            System.out.println("pc:" + pc + "   c:" + c);
        }
    }
}

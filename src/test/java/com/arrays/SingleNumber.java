package com.arrays;


/**
 * Created by zhangwei on 2018/5/24.
 * 只出现一次的数字
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {

    public static void main(String[] s){
        System.out.println(0^1^1);
        System.out.println(0^2^2);
        System.out.println(0^3^3);
        int a = new SingleNumber().singleNumber(new int[]{1,2,1});
        System.out.println(a);
    }

    //beats 100%
    public int singleNumber(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1]^nums[i];
        }
        return nums[nums.length-1];
    }
}

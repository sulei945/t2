package com.arrays;

import java.util.Arrays;

/**
 * Created by zhangwei on 2018/3/28.
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 众数：数组众出现此时超过数组长度一半的数
 * 思路：根据众数的定义，这个数出现的次数超过其它数字的总和，那么当不断的任意删除数组中两个不相同的数之后，最后剩下的数肯定是众数。
 */
public class MajorityElement {


    public static void main(String[] s){
        int[] num = {1,2,3,2,2,1,5,2,2,2,9};
        majorityElement(num);
    }

    /**
     * 遍历一遍数组，用candidate记录当前数字，用count记录当前数字还未抵消的个数
     * 当发现不同数字出现，用当前candidate的数字与循环到的数字抵消一个即删除两个不同的数字，count--
     * 如果count为0了，说明之前的都抵消完了，就把新遍历的数字那来做candidate，count数为1，继续往后遍历，直到结束。
     * @param num
     * @return
     */
    //beats 50.87%
    private static int majorityElement(int[] num) {
        int count = 1;
        int candidate = num[0];
        for (int i = 1; i<num.length; i++) {
            //目前得到的数出现次数为0时，更换另外一个数
            if (count == 0) {
                candidate = num[i];
                count = 1;
            } else {
                if (candidate == num[i])
                    count++;               //相同+1
                else
                    count--;              //不同-1，
            }
        }
        return candidate;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

package com.arrays;

import java.util.Arrays;

/**
 * Created by zhangwei on 2018/5/22.
 *  旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static void main(String[] s){
        new RotateArray().myRotate(new int[]{-1}, 3);
    }

    //beats 93.12%
    public void myRotate(int[] nums, int k) {
        int l = nums.length;
        //如果k大于数组长度时，会走至少一个循环，所以可以忽略整个循环的移动次数，否则后面的算法会有数组越界情况
        while (k > l){
            k -= l;
        }

        int lk = l - k;
        int[] numsk = Arrays.copyOfRange(nums, lk, l);
        for(int i=lk-1; i>=0; i--){
            nums[i+k] = nums[i];
        }
        for(int i=0; i<k; i++){
            nums[i] = numsk[i];
        }
    }


    public class Solution {
        public void rotate(int[] nums, int k) {
            int temp, previous;
            for (int i = 0; i < k; i++) {
                previous = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = previous;
                    previous = temp;
                }
            }
        }
    }
    public class Solution2 {
        public void rotate(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                a[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = a[i];
            }
        }
    }
    public class Solution3 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }
        }
    }
    public class Solution4 {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }


}

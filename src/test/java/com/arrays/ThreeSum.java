package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhangwei on 2018/4/17.
 */
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//找出数组中所有的三个数组合，条件是和为0
public class ThreeSum {

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        new ThreeSum().threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        new ThreeSum().threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        //i位 代表最小的负数， j，k都比i大，且k位应该是正数
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;  //当i位大于0时，不可能找到三个和为0的数
            //过滤掉i位数相同都情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];

            //i不变时，通过jk变化找到合适都数，不断偏移jk找平衡，条件是j<k,当条件不符合时说明已经找遍了
            //转化成
            while (j < k) {
                if (nums[j] + nums[k] == target) {   //找到目标
                    List<Integer> temp = new ArrayList<Integer>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    result.add(temp);
                    //更改jk
                    j++;
                    k--;

                    //更改后过滤掉j位相同都情况
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    //更改后过滤掉k位相同都情况
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] > target) { //偏大时，减小大值
                    k--;
                } else {    //偏小调整小值
                    j++;
                }
            }
        }

        return result;
    }

    //去重时while的写法，没循环体的写法
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);

        int i = 0;
        while (i < length - 2) {
            if (nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sums = nums[i] + nums[j] + nums[k];
                if (sums == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sums <= 0) {
                    //消去左侧重复的数字
                    while (nums[j] == nums[++j] && j < k) ;
                }
                if (sums >= 0) {
                    //消去右侧重复的数字
                    while (nums[k--] == nums[k] && j < k) ;
                }

            }
            //消去和当前左指针相同的数字
            while (nums[i] == nums[++i] && i < nums.length - 2) ;

        }
        return result;
    }

    //利用hashmap/hashset是为了避开重复的值，但是效率值明显不如上一种方法高
    public List<List<Integer>> threeSum3(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1, k = num.length - 1; j < k; ) {
                if (num[i] + num[j] + num[k] == 0) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(num[k]);
                    if (set.add(l))
                        list.add(l);
                    j++;
                    k--;
                } else if (num[i] + num[j] + num[k] < 0)
                    j++;
                else
                    k--;
            }
        }
        return list;
    }
}

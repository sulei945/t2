package com.arrays;

import java.util.HashMap;

/**
 * Created by zhangwei on 2018/4/17.
 * 给定一个数字，从数组中找出两个元素和为此数字的组合
 */
public class TwoSum {

    public static void main(String[] s){
        System.out.println(new TwoSum().twoSum(new int[]{2, 7, 11, 18}, 9)[0]);

        new TwoSum().twoSum2(new int[]{2, 3, 4, 5, 6, 7, 11, 18}, 9);
    }

    /**
     *  获取两个元素和，因为是排序过的，所以小的和比较大的元素加起来会是target，
     *  所以从数组两端往中间汇合计算.
     *  如果不是排序可以先对数组进行排序，Arrays.sort(nums);
     */
    public void twoSum2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r){
            if(nums[r] > target){   //前提非负数集合,如果有负的，可以去掉此if条件
                r--;
            }else {
                int temp = nums[l] + nums[r];
                if(temp > target){
                    r--;
                }else if(temp < target){
                    l++;
                }else{
                    System.out.println(l + " " + r);
                    r--;
                    l++;
                }
            }
        }
    }

    //beats 44.9%
    public int[] myTwoSum(int[] numbers, int target) {
        int f = 0;
        int t = numbers.length-1;
        while(f<t){
            if(numbers[f] + numbers[t] == target){
                return new int[]{++f, ++t};
            }
            if(numbers[f] + numbers[t] > target){
                t--;
            }else{
                f++;
            }
        }
        return null;
    }

    public int[] twoSumBeats100(int[] numbers, int target) {

        int center = target / 2;
        int begin = 0;
        int end = numbers.length - 1;
        while (end - begin > 1) {
            int index = (end + begin) / 2;
            int temp = numbers[index];
            if (temp == center) {
                begin = index;
                end = index + 1;
            } else if (temp > center) {
                end = index;
            } else {
                begin = index;
            }
        }

        int sum = numbers[begin] + numbers[end];
        if (sum > target) {
            sum = numbers[--begin] + numbers[--end];
        }
        while (sum != target) {
            if (sum > target) {
                if (--begin < 0) {
                    break;
                }
            } else {
                if (++end == numbers.length) {
                    break;
                }
            }
            sum = numbers[begin] + numbers[end];
        }
        return new int[] {begin + 1, end + 1};
    }

    //借助hash实现,不要求原数组是否是排序的，时间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}

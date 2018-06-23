package com.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by zhangwei on 2018/5/23.
 */
public class ThirdMaximumNumber {
    public static void main(String[] s){
        new ThirdMaximumNumber().myThirdMax1(new int[]{1,2,2,5,3,5});
    }

    //beats 81.44%
    public int myThirdMax(int[] nums) {
        long fir = Long.MIN_VALUE;
        long sed = Long.MIN_VALUE;
        long thd = Long.MIN_VALUE;
        for(int i= 0; i<nums.length; i++){
            if(nums[i] > thd){
                if(nums[i]==sed) continue;
                else if(nums[i]>sed){
                    if(nums[i]==fir) continue;
                    else if(nums[i] > fir){
                        thd = sed;
                        sed = fir;
                        fir = nums[i];
                        continue;
                    }
                    thd = sed;
                    sed = nums[i];
                    continue;
                }
                thd = nums[i];
            }
        }
        if(thd == Long.MIN_VALUE){
            return (int)fir;
        }
        return (int)thd;
    }

    //beats 35.05%
    public int myThirdMax1(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length-1;
        int r = nums[l--];
        int n = 1;
        while (l >= 0 && n<3){
            if(nums[l] != r){
                r = nums[l];
                n++;
            }
            l--;
        }
        if(n == 3){
            return r;
        }
        return nums[nums.length-1];
    }

    //beats 25.77%
    public int myThirdMax2(int[] nums) {
        int minValue = nums[0];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(minValue);
        for(int i= 1; i<nums.length; i++){
            if(queue.size() < 3){
                if(!queue.contains(nums[i])){
                    queue.offer(nums[i]);
                    minValue = queue.peek();
                }

            }else if(nums[i] > minValue){
                if(!queue.contains(nums[i])){
                    queue.offer(nums[i]);
                    if(queue.size() > 3){
                        queue.poll();
                    }
                    minValue = queue.peek();
                }
            }
        }
        if(queue.size() < 3){
            int r = queue.poll();
            while (!queue.isEmpty()){
                r = queue.poll();
            }
            return r;
        }
        return queue.peek();
    }

    //beats 15.46%
    public int myThirdMax3(int[] nums) {
        int minValue = nums[0];
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(minValue);
        for(int i= 1; i<nums.length; i++){
            if(set.size() < 3){
                set.add(nums[i]);
                minValue = set.first();
            }else if(nums[i] > minValue){
                set.add(nums[i]);
                if(set.size() > 3){
                    set.remove(minValue);
                }
                minValue = set.first();
            }
        }

        if(set.size() < 3){
            return set.last();
        }
        return set.first();
    }

    public int thirdMax(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;
        boolean foundZero = false;

        for (int i = 0; i < nums.length; ++i) {
            if (count < 3 && nums[i] == 0 && !foundZero) {
                foundZero = true;
            } else if (nums[i] == a || nums[i] == b || nums[i] == c) {
                continue;
            }
            if (nums[i] > a || count == 0) {
                c = b;
                b = a;
                a = nums[i];
                ++count;
            } else if (nums[i] > b || count == 1) {
                c = b;
                b = nums[i];
                ++count;
            } else if (nums[i] > c || count == 2) {
                c = nums[i];
                ++count;
            }
        }

        return count >= 3 ? c : a;
    }

}

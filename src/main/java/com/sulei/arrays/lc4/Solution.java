package com.sulei.arrays.lc4;

/**
 * Created by zhangwei on 2018/1/24.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 */
public class Solution {

    public static void main(String[] str){
        int[] nums1 = {1, 2};
        int[] nums2 = {2,3};
        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }

    //todo
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        //中间位置，需要根据奇偶数区分
        int ms = (l1 + l2)/2;
        boolean now1 = false;
        boolean end1 = false;
        boolean end2 = false;
        int ai= 0; int bi = 0; int i = 0;
        while (i <= ms){
            if(end1){
                bi++;
                now1 = false;
            }else if(end2){
                ai++;
                now1 = true;
            }else {
                if(nums1[ai] < nums2[bi]){
                    if(ai < l1-1){
                        ai++;
                    }else {
                        end1 = true;
                    }
                    now1 = true;
                }else {
                    if(bi < l2-1){
                        bi++;
                    }else {
                        end2 = true;
                    }
                    now1 = false;
                }
            }
            i++;
        }

        int mv = 0;
        if(now1){
            if(ai == 0){
                mv = nums1[ai];
            }else {
                mv = nums1[ai-1];
            }
        }else {
            if(bi == 0){
                mv = nums2[bi];
            }else {
                mv = nums2[bi-1];
            }
        }

        //奇数用nmv直接返回
        if(ms % 2 == 1){
            return mv;
        }else {
            //偶数用ml和下一个一起／2返回
            int nmv = nums1[ai] < nums2[bi] ? nums1[ai] : nums1[bi];
            return (mv+nmv)/2.0;
        }
    }

}

package com.arrays;

/**
 * Created by zhangwei on 2018/4/2.
 * 合并两个有序数组
 * 给定两个排序整数数组NUS1和NUMS2，将NUMS2合并为NUMS1作为一个排序的数组。
 注：
 在NUMS1和NUMTS2中初始化的元素的数量分别为M和N。
 您可以假设NUMS1有足够的空间（大小大于或等于M+N）来保存NUMTS2中的附加元素。

 * 思路：因为都是有序的，假如都是升序的。
 * 两个指针从后往前遍历，比较把大的赋值到数组的最后面，这样一次遍历可解决，不用移动数据。
 *
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    //beats 99.91%
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        while (m>0 || n>0){
            if(m > 0 && n>0){
                if(nums1[m-1] > nums2[n-1]){
                    nums1[index] = nums1[m-1];
                    m--;
                }else {
                    nums1[index] = nums2[n-1];
                    n--;
                }
            }else if(m <= 0){
                nums1[index] = nums2[n-1];
                n--;
            }else {
                nums1[index] = nums1[m-1];
                m--;
            }
            index--;
        }
    }

}

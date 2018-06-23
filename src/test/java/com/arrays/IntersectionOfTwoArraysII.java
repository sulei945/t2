package com.arrays;

import java.util.Arrays;

/**
 * Created by zhangwei on 2018/5/26.
 * 两个数组的交集 II
 *
 给定两个数组，写一个方法来计算它们的交集。

 例如:
 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

 注意：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。

 跟进:
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectionOfTwoArraysII {

    //beats 100% 1.对数组排序。2.通过两个指针分别指向两个数组中的位置，依次后移对比数据
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] r = new int[l1>l2?l2:l1];
        int c1 = 0;
        int c2 = 0;
        int rc = 0;
        while (c1 < l1 && c2 < l2){
            if(nums1[c1] == nums2[c2]){
                r[rc] = nums1[c1];
                c1++;
                c2++;
                rc++;
            }else if(nums1[c1] > nums2[c2]){
                c2++;
            }else {
                c1++;
            }
        }

        return Arrays.copyOfRange(r, 0, rc);
    }

}

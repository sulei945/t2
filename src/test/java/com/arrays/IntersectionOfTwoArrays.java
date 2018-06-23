package com.arrays;

import java.util.*;

/**
 * Created by zhangwei on 2018/5/22.
 * 两个数组的交集

 给定两个数组，写一个函数来计算它们的交集。

 例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

 提示:

 每个在结果中的元素必定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] s){
        new IntersectionOfTwoArrays().myIntersection1(new int[]{1}, new int[]{1});
    }

    //beats 11.43%
    public int[] myintersection(int[] nums1, int[] nums2) {
        //先对数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //以更小对数组对长度为基准创建一个列表
        List<Integer> result = new ArrayList<Integer>(nums1.length>nums2.length?nums2.length:nums1.length);

        for(int i=0; i<nums1.length; i++){
            //忽略nums1里相同元素的数据
            if(i > 0 && nums1[i-1] == nums1[i]) continue;
            //todo 这样循环好像会重复很多次每必要的情况
            for(int j=0; j<nums2.length; j++){
                //忽略nums2里相同元素的数据
                if(j > 0 && nums2[j-1] == nums2[j]) continue;
                //遇到相同的元素保存起来
                if(nums1[i] == nums2[j]){
                    result.add(nums1[i]);
                }
            }
        }
        //整理并返回结果
        int[] r = new int[result.size()];
        for(int i=0; i<r.length; i++){
            r[i] = result.get(i);
        }
        return r;
    }

    //beats 49.8%
    public int[] myIntersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] r = new int[l1>l2?l2:l1];
        int c1 = 0;
        int c2 = 0;
        int rc = 0;
        while (c1 < l1 && c2 < l2){
            if(c1>0 && nums1[c1] == nums1[c1-1]){
                c1++;
                continue;
            }
            if(c2>0 && nums2[c2] == nums2[c2-1]){
                c2++;
                continue;
            }
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

    //beats 93.06%
    public int[] myintersection2(int[] nums1, int[] nums2) {
        //将nums1里的数据放在set里
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums1){
            set.add(i);
        }

        List<Integer> result = new ArrayList<Integer>(nums1.length);
        //分别对nums2里的数据探测是否是重合的
        for(int i:nums2){
            if(set.contains(i)){
                result.add(i);
                set.remove(i);
            }
        }
        //整理并返回结果
        int[] r = new int[result.size()];
        for(int i=0; i<r.length; i++){
            r[i] = result.get(i);
        }
        return r;
    }

    //beats 99.18%
    public int[] myintersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums1){
            set.add(i);
        }
        //直接使用int[]来存储数据
        int[] res = new int[nums1.length];
        int c = 0;
        for(int i:nums2){
            if(set.contains(i)){
                res[c++]=i;
                set.remove(i);
            }
        }
        //截取有效数据
        return Arrays.copyOfRange(res, 0, c);   //!!!!!!
    }

    //beats 100%
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        int index = 0;
        //对nums1里对所有数据做处理，通过对数子对应的位设置标记来记录数据
        BitSet set = new BitSet();  //!!!!!!!
        for (int i = 0; i < nums1.length; i++) {
            set.set(nums1[i]);
        }
        //分别查看nums2里的所有数字对应的bit位标记的情况比对是否是nums1里存在的
        for (int i = 0; i < nums2.length; i++) {
            if (set.get(nums2[i]) == true) {
                res[index++] = nums2[i];
                set.set(nums2[i], false);
            }
        }
        //截取有效数据
        return Arrays.copyOfRange(res, 0, index);
    }
}

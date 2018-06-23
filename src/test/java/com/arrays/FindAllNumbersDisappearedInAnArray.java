package com.arrays;

import sun.jvm.hotspot.oops.ShortField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2018/5/28.
 * 找到所有数组中消失的数字
 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

 找到所有在 [1, n] 范围之间没有出现在数组中的数字。

 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

 示例:
 输入:
 [4,3,2,7,8,2,3,1]
 输出:
 [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] s){
        new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    //beats 91.09% 使用了额外的空间
    public List<Integer> myFindDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<Integer>();
        if(nums.length == 0) return r;
        //遍历每个元素，将数据放在对应位置上
        for(int i=0; i<nums.length; i++){
            //记录当前位置元素的值
            int x = nums[i];
            //将数据放在对应位置上
            while (nums[x-1] != x){
                //保存对应位置的元素值
                int y = nums[x-1];
                //将当前位置元素的值转移到对应的位置上
                nums[x-1] = x;
                //设置下次while循环条件
                x = y;
            }
        }
        //循环每个元素，如果对应位置上的数据不是应该存在的值，说明缺少这个值
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                r.add(i+1);
            }
        }
        return r;
    }


    //beats 62.38%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        //遍历每个元素，将此元素中保存的值对应的数组下标里存在的值设成负数，
        // 如nums[0] = 5,则将nums[4]设为-nums[4]
        for(int i = 0; i < nums.length; i++) {
            //因为有可能当前nums[i]的值已经被设置成负数了，所以要用绝对值（Math.abs(nums[i])）再减1来取下标
            int val = Math.abs(nums[i]) - 1;
            //因为有的数字会出现多次，所以要判断一下是否大于0，即未被设负过
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        //遍历每个元素，大于0的元素对应坐标即未出现的数字
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }



}
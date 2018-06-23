package com.arrays;

/**
 * Created by zhangwei on 2018/5/25.
 * 移动零
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]

 说明:
 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */
public class MoveZeroes {
    public static void main(String[] s){
        new MoveZeroes().moveZeroes(new int[]{0,1,0,3,12});
    }

    //beats 57.2%
    public void myMoveZeroes(int[] nums) {
        int zn = 0;
        for(int i:nums){
            if(i == 0){
                zn++;
            }
        }
        int c = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(i != c){
                    nums[c] = nums[i];
                }
                c++;
            }
        }
        for(int i=nums.length-1; i>=nums.length-zn; i--){
            nums[i] = 0;
        }
    }

    //beats 57.2%
    public void myMoveZeroes1(int[] nums) {
        int c = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(i != c){
                    nums[c] = nums[i];
                }
                c++;
            }
        }
        for(int i = c; i<nums.length; i++){
            nums[i] = 0;
        }
    }

    //beats 100%
    public void moveZeroes(int[] nums){
        int pos=0;
        for(int x:nums) if(x!=0) nums[pos++]=x;
        while(pos<nums.length) nums[pos++]=0;
    }
}

package com.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/17.
 * 重塑矩阵
 * 将原始矩阵重塑成r行c列的新矩阵
 * 元素顺序需要保持一致，如果新矩阵和老矩阵的元素不想等时返回老矩阵
 */
public class ReshapetheMatrix {

    public int[][] myMatrixReshape(int[][] nums, int r, int c) {
        if(r <= 0 || c <= 0) return nums;
        int x = nums.length;
        int y = nums[0].length;
        if(x*y != r*c) return nums;

        int[][] rcs = new int[r][c];
        int rr = 0; int cc = 0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                rcs[rr][cc] = nums[i][j];
                if(++cc == c){
                    cc=0;
                    rr++;
                }
            }
        }
        return rcs;
    }

    public int[][] myMatrixReshape2(int[][] nums, int r, int c) {
        if(r <= 0 || c <= 0) return nums;
        int x = nums.length;
        int y = nums[0].length;
        if(x*y != r*c) return nums;

        int[][] rcs = new int[r][c];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                queue.offer(nums[i][j]);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rcs[i][j]=queue.poll();
            }
        }
        return rcs;
    }
}

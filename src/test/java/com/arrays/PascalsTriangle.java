package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2018/5/24.
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class PascalsTriangle {
    public static void main(String[] s){
        new PascalsTriangle().generate(5);
    }

    //beats 100%
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;
        List<Integer> l1 = new ArrayList<Integer>(1);
        l1.add(1);
        result.add(l1);
        if(numRows>1){
            List<Integer> l2 = new ArrayList<Integer>(1);
            l2.add(1);
            l2.add(1);
            result.add(l2);
        }
        for (int i=3; i<=numRows; i++){
            List<Integer> list = new ArrayList<Integer>(i);
            list.add(1);
            List<Integer> preList = result.get(i-2);
            for(int j=1;j<i-1; j++){
                list.add(j, preList.get(j-1)+preList.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}

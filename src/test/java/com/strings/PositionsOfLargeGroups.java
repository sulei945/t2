package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2018/5/15.
 *
 *
    给一个字符串，返回大于等于3个的连续字符位置
    Input: "abc"
    Output: []

    Input: "abbxxxxzzy"
    Output: [[3,6]]

    Input: "abcdddeeeeaabbbcd"
    Output: [[3,5],[6,9],[12,14]]
 */
public class PositionsOfLargeGroups {
    public static void main(String[] s){
        new PositionsOfLargeGroups().largeGroupPositions("aaa");
    }

    public List<List<Integer>> myLargeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length()<3){
            return result;
        }
        char[] chars = S.toCharArray();
        char c = chars[0];
        int ci = 1;
        for(int i = 1; i<chars.length; i++){
            if(c == chars[i]){
                ci++;
            }else {
                c = chars[i];
                if(ci >= 3){
                    List<Integer> l = new ArrayList<Integer>(2);
                    l.add(i-ci);
                    l.add(i-1);
                    result.add(l);
                }
                ci = 1;
            }
        }
        if(ci >= 3){
            int i = chars.length-1;
            List<Integer> l = new ArrayList<Integer>(2);
            l.add(i-ci);
            l.add(i);
            result.add(l);
        }
        return result;
    }


    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}

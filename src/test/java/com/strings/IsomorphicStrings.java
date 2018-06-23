package com.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsomorphicStrings {
    public static void main(String[] s){
        new IsomorphicStrings().isIsomorphic("baa", "cfa");
    }

    //beats 78.89%
    public boolean myIsIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;

        char[] chars = s.toCharArray();
        int[] temp = new int[chars.length];
        int c = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(chars[0], 0);
        for(int i=1; i<chars.length; i++){
            Integer ci = map.get(chars[i]);
            if(ci == null){
                temp[i] = c++;
                map.put(chars[i], temp[i]);
            }else{
                temp[i] = ci;
            }
        }

        map.clear();
        char[] tcs = t.toCharArray();
        map.put(tcs[0], 0);
        c = 1;
        for(int i=1; i<tcs.length; i++){
            Integer ci = map.get(tcs[i]);
            if(ci == null){
                if(temp[i] != c++){
                    return false;
                }
                map.put(tcs[i], temp[i]);
            }else if(ci != temp[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * beats 100%
     * 将 字母char 看成数字，范围在0-256
     * 那么可以看作两个数字排列方式是否相同如
     * 1 2 1 2
     * 3 4 3 4
     * 那么可以看出是1-3,2-4的对应关系
     * 将数组 1 的位置存 3 ，2的位置存4，
     * 同样另一个数组 3的位置存1， 4的位置存2
     * 一边遍历数组一边构建关系，重复出现的数字做验证，通过ok，不通过说明有问题
     */
    public boolean isIsomorphic(String sString, String tString) {
        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }

    //beats 96.67%
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

}

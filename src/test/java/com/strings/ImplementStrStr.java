package com.strings;

/**
 * Created by zhangwei on 2018/5/24.
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImplementStrStr {
    public static void main(String[] s){
        new ImplementStrStr().strStr("ippi", "pi");
    }

    //beats 91.8%
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0) return 0;
        if(haystack.length() == needle.length()) return haystack.equals(needle)?0:-1;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int hnl = hc.length-nc.length;
        int okl = nc.length-1;
        for(int i=0; i<=hnl; i++){
            for(int j=0; j<nc.length; j++){
                if(hc[i+j] != nc[j]){
                    break;
                }
                if(j == okl){
                    return i;
                }
            }
        }
        return -1;
    }

}

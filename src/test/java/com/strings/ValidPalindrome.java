package com.strings;

/**
 * Created by zhangwei on 2018/5/22.
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome {

    public static void main(String[] s){
        new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
    }

    //beats 61.76%
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int f = 0;
        int t = chars.length-1;
        while (f<t){
            if(!Character.isLetter(chars[f]) && !Character.isDigit(chars[f])) {f++; continue;}
            if(!Character.isLetter(chars[t]) && !Character.isDigit(chars[t])) {t--; continue;}
            if(chars[f] != chars[t]){
                return false;
            }
            f++;
            t--;
        }
        return true;
    }

}

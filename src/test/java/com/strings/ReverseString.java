package com.strings;

/**
 * Created by zhangwei on 2018/5/21.
 反转字符串
 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {

    //beats 45.51%
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //beats 15.28%
    public String reverseString2(String s) {
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=l-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //beats 45.51%
    public String reverseString3(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString4(String s) {
        return null;
    }
}

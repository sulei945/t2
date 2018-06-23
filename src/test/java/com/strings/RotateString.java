package com.strings;

/**
 * Created by zhangwei on 2018/5/15.
 * 如果A=＝ABCDE，则在A上的一个移位之后它将是“BCDEA”，当且仅当A上的一些移位之后，A可以变成B时，返回真。
 Example 1:
     Input: A = 'abcde', B = 'cdeab'
     Output: true

 Example 2:
    Input: A = 'abcde', B = 'abced'
    Output: false
 */
public class RotateString {

    public boolean myRotateString(String A, String B) {
//        if(A.length() != B.length()) return false;
        if(A.length() == 0) return false;
        char b = B.charAt(0);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == b) {
                String AA = A.substring(i, A.length()) + A.substring(0, i);
                if (AA.equals(B)) {
                    return true;
                }

            }

        }
        return false;
    }

    public static void main(String[] s) {
        new RotateString().myRotateString("abcde", "cdeab");
    }
}

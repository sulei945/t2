package com.dp;

/**
 * Created by zhangwei on 2018/4/27.
 */
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

//Example:
//Input: "babad"
//Output: "bab"

//Note: "aba" is also a valid answer.

//Example:
//Input: "cbbd"
//Output: "bb"
//找出最长回文字串 （回文：对称的）
//    https://www.cnblogs.com/leavescy/p/5878336.html
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s1 = myLongestPalindrome("babad");
        System.out.println(s1);

        String s2 = myLongestPalindrome("cbbd");
        System.out.println(s2);
    }

    //暴力
    public static String myLongestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int length = cs.length;
        int maxFrom = 0;
        int max = 0;
        for(int i = 0; i<length-1; i++){
            //后面不可能有比这个还长的回文串了，直接返回
            if(max + i > length){
                return s.substring(maxFrom, maxFrom+max);
            }
            for(int j = i+1; j<length; j++){
                //预判可能替换之前出现的最常串
                if(cs[i] == cs[j] && j-i>max){
                    int x = i;
                    int y = j;
                    //判断是否是回文串，如果是就找到了一个更长的回文串
                    boolean isok = true;
                    while (x<y){
                        if(cs[x] == cs[y]){
                            x++;y--;
                        }else {
                            isok = false;
                            break;
                        }
                    }
                    if(isok){
                        maxFrom = i;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(maxFrom, maxFrom+max);
    }

    public static String myLongestPalindromeDP(String s){

        return null;
    }

    /**
     * 动态规划
     * P[i,j]=false:表示子串[i,j]不是回文串。P[i,j]=true:表示子串[i,j]是回文串。
     * P[i,i]=true:
     * 当且仅当P[i+1,j-1] = true && (s[i]==s[j]）则 P[i,j]=true
     * 否则p[i,j] =false;
     */
    public static String findLongestPalindrome1(String s){
        int len = s.length();
        int start = 0;
        int maxlength = 0;
        boolean p[][] = new boolean[s.length()][s.length()];
        // 子串长度为1和为2的初始化
        for(int i = 0; i < len; i++){
            p[i][i] = true;
            if(i < len - 1 && s.charAt(i) == s.charAt(i + 1)){
                p[i][i + 1] = true;
                start = i;
                maxlength = 2;
            }
        }
        // 使用上述结果可以dp出子串长度为3~len -1的子串
        for(int strlen = 3; strlen < len; strlen ++){
            for(int i = 0; i <=len - strlen; i++){
                int j = i + strlen - 1; // 子串结束的位置
                if(p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    p[i][j] = true;
                    maxlength = strlen;
                    start = i;
                }
            }
        }
        if(maxlength > 0)
            return s.substring(start, start + maxlength);
        return null;
    }



    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        String longestPalindromicSubstring = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(j - i > longestPalindromicSubstring.length() && isPalindrome(s.substring(i, j))) {
                    longestPalindromicSubstring = s.substring(i, j);
                }
            }
        }

        return longestPalindromicSubstring;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

}

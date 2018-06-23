package com.queue;

import java.util.LinkedList;

/**
 * Created by zhangwei on 2018/5/16.
 * 判断一个数组是否是回文的
 * 如 121 true
 *    -121 false
 *    12  false
 *    10  false
 */
public class PalindromeNumber {
    public static void main(String[] s){
        new PalindromeNumber().isPalindrome(15);
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (x > 0){
            list.offer(x%10);   //个位
            x = x/10;   //除10后
        }

        while (list.size() > 1){
            int f = list.removeFirst();
            int e = list.removeLast();
            if(f != e){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        String y = String.valueOf(x);
        char[] chars = y.toCharArray();
        int f = 0;
        int e = chars.length-1;
        while (f<e){
            if (chars[f] != chars[e]) {
                return false;
            }else {
                f++; e--;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if(x < 0) return false;
        int div = 1;    //位数
        while(div<=x/10)
            div *= 10;
        while(x>0){
            if(x/div!=x%10)
                return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }

    //效率很低
    public boolean isPalindrome4(int x) {
        String s = Integer.toString(x); //convert to string
        StringBuilder str = new StringBuilder(s); //make string mutable for manipulation
        return (str.reverse().toString().equals(s) ? true : false); //check if reversed string is equal to original

    }

    /*public bool IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }*/

}

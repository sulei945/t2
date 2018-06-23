package com.binary;

import java.math.BigInteger;

/**
 * Created by zhangwei on 2018/5/17.
 * 二进制相加
 Example 1:
     Input: a = "11", b = "1"
     Output: "100"
 Example 2:
     Input: a = "1010", b = "1011"
     Output: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        boolean carry = false;

        // walk from the back
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = Math.max(a.length(), b.length());

        // account for carry digit
        char [] arr = new char[k + 1];

        while (k > 0) {
            char aBit = i >= 0 ? a.charAt(i--) : '0';
            char bBit = j >= 0 ? b.charAt(j--) : '0';

            if (aBit == '1' && bBit == '1') {
                if (carry) {
                    arr[k] = '1';
                } else {
                    arr[k] = '0';
                }
                carry = true;
            } else if (aBit == '1' || bBit == '1') {
                if (carry) {
                    arr[k] = '0';
                    carry = true;
                } else {
                    arr[k] = '1';
                }
            } else {
                if (carry) {
                    arr[k] = '1';
                    carry = false;
                } else {
                    arr[k] = '0';
                }
            }
            k--;
        }

        if (carry) {
            arr[k] = '1';
        }
        StringBuilder sb = new StringBuilder();

        // Ommit the first character if there was no carry
        i = carry ? 0 : 1;
        for (; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    //效率极高
    public String addBinary1(String a, String b) {
        int m = a.length(), n = b.length(), k = Math.max(m, n) + 1;
        int[] res = new int[k];
        int ca, cb, c = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            ca = a.charAt(i--) - '0';
            cb = b.charAt(j--) - '0';
            res[--k] = ca ^ cb ^ c + '0';
            c = (ca & cb) | (cb & c) | (c & ca);
        }
        while (i >= 0) {
            ca = a.charAt(i--) - '0';
            res[--k] = ca ^ c + '0';
            c = ca & c;
        }
        while (j >= 0) {
            cb = b.charAt(j--) - '0';
            res[--k] = cb ^ c + '0';
            c = cb & c;
        }
        res[0] = c + '0';
        c = c == 1 ? 0 : 1;
        return new String(res, c, res.length - c);
    }

    //效率极低
    public String addBinary2(String a, String b) {
        return (new BigInteger(a, 2).add(new BigInteger(b, 2))).toString(2);

    }

    //todo
    /*public String addBinary2(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int al = ac.length;
        int bl = bc.length;
        int l = al > bl ? bl : al;
        boolean hi = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=l; i++){
            char x;
            char y;
            if(i == l){
                if(al>bl){
                    x = ac[al-i];
                    y = 0;
                }else {
                    x = 0;
                    y = bc[bl-i];
                }
            }else{
                x = ac[al-i];
                y = bc[bl-i];
            }

            if(x == '1' && y == '1'){
                if(hi)
                    sb.append("1");
                else {
                    hi = true;
                    sb.append("0");
                }
            } else if(x == '0' && y == '0'){
                if(hi) sb.append("1");
                else sb.append("0");
                hi = false;
            }else{
                if(hi) sb.append("0");
                else {
                    sb.append("1");
                    hi = false;
                }
            }
        }
        if(al == bl && hi) sb.append("1");
        else if(al > bl +1){
            a.substring(0, al - bl -1);

        }

        return null;
    }*/
}

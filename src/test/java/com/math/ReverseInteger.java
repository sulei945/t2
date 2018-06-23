package com.math;

/**
 * Created by zhangwei on 2018/5/22.
 * 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * 示例 1:
 输入: 123
 输出: 321

 示例 2:
 输入: -123
 输出: -321

 示例 3:
 输入: 120
 输出: 21
 */
public class ReverseInteger {

    public static void main(String[] s){
        new ReverseInteger().reverse(-123);
    }

    //beats 84.39%
    public int myReverse(int x) {
        int r = 0;
        int c = 0;
        while (x != 0){
            c = x % 10;
            r = r * 10 + c;
            x /= 10;
        }

        return r % 10 == c ? r : 0; //!!!!!!!!
    }

    //wrong
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
            if (Integer.MAX_VALUE / 10 < Math.abs(res)) {
                return 0;
            }
        }
        return res;
    }
}

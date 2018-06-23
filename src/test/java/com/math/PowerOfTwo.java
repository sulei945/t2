package com.math;

/**
 * 2的幂
 * 给定一个整数，写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 * 输入: 1
 * 输出: true
 *
 * 示例 2:
 * 输入: 16
 * 输出: true
 *
 * 示例 3:
 * 输入: 218
 * 输出: false
 */
public class PowerOfTwo {

    //beats 54.56%
    public boolean myIsPowerOfTwo(int n) {
        if(n == 1) return true;

        while(n % 2 == 0 && n > 2) {
            n/=2;
        }
        return n == 2;
    }

    //all n <= 0 is not a power of 2
    //every power of 2 has only one '1' in its set bit i.e. (1000 (8), 10000 (16))
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (Integer.bitCount(n) == 1);
    }

    public boolean isPowerOfTwo2(int n) {
        return n<=0 ? false : (n&(n-1)) == 0;
    }

}

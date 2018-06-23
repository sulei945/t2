package com.binary;

import static java.lang.Integer.bitCount;

/**
 * Created by zhangwei on 2018/5/25.
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 示例 :
 输入: 11
 输出: 3
 解释: 整数 11 的二进制表示为 00000000000000000000000000001011


 示例 2:
 输入: 128
 输出: 1
 解释: 整数 128 的二进制表示为 00000000000000000000000010000000
 */
public class NumberOf1Bits {

    public static void main(String[] s){
        int mask = 1;
        System.out.println(mask);

        mask <<= 1;     //二进制左移一位
        System.out.println(mask);

        mask <<= 1;
        System.out.println(mask);

        mask <<= 1;
        System.out.println(mask);

        mask >>= 1;
        System.out.println(mask);
    }

    //beats 100%
    public int myHammingWeight(int n) {
        return Integer.bitCount(n);
    }

    //int为32位，对32位分别判断是否是1
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;   //初始化位第一位1
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {  //& 按位与，两个数字的二进制标识的值，进行32位两两与操作，因为mask的二进制形式只有一个1，因此当n的当前位是1时&之后为非0
                bits++;
            }
            mask <<= 1; //左移一位
        }
        return bits;
    }


    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


}

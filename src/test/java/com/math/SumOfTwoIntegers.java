package com.math;

/**
 * Created by zhangwei on 2018/5/26.
 * 两整数之和
 不使用运算符 + 和-，计算两整数a 、b之和。

 示例：
 若 a = 1 ，b = 2，返回 3。
 */
public class SumOfTwoIntegers {
    //todo ?
    public int getSum(int a, int b) {
        //Sum of two bits can be obtained by performing XOR (^) operation of two bits.
        //Carry bit can be obtained by performing AND (&) operation of two bits
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    //todo ?
    public int getSum2(int a, int b) {
        if(b == 0){//没有进为的时候完成运算
            return a;
        }
        int sum,carry;
        sum = a^b;//完成第一步加发的运算
        carry = (a&b)<<1;//完成第二步进位并且左移运算
        return getSum(sum,carry);//
    }

    public int getSum3(int a, int b) {
        int result = 0;
        while ((a ^ b) != a) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            result = tempA ^ tempB;
            a = tempA;
            b = tempB;
        }
        return result;
    }

}

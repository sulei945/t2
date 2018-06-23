package com.binary;

/**
 * Created by zhangwei on 2018/5/17.
 * 对给定的两个数字区间中所有数字，对数字的二进制表示中1的数量是素数的个数
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static void main(String[] s){
        new PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(567, 607);
    }

    public int countPrimeSetBits(int L, int R) {
        int r = 0;
        for(int i=L; i<=R; i++){
            int bc = Integer.bitCount(i);
            if(isPrime(bc)){
                r++;
            }
        }
        return r;
    }

    private boolean isPrime(int i){
        if(i==2 || i==3 || i ==5 || i==7 || i==11 || i== 13
                || i== 17 || i== 19){
            return true;
        }
        return false;
    }
}

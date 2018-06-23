package com.math;

import org.omg.PortableServer.POA;

import java.util.Arrays;

/**
 * Created by zhangwei on 2018/5/21.
 * 给定一个数组用来表示一个整数，对此整数做加一操作，返回加一后的数组表示
 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]， 数字123 + 1 = 124

 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]， 数字4321+1=4322
 */
public class PlusOne {
    public static void main(String[] s){
        new PlusOne().plusOne(new int[]{9, 9});
    }

    //beats 68.51%
    public int[] plusOne(int[] digits) {
        int dl = digits.length;
        int lastNum = digits[dl-1];
        if(lastNum<9){
            digits[dl-1] = lastNum+1;
            return digits;
        }else {
            digits[dl-1] = 0;
        }
        if(dl == 1){
            return new int[]{1,0};
        }
        for (int i=dl-2; i>=0; i--){
            int next = digits[i];
            if(next < 9){
                digits[i] = next+1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[dl+1];
        for(int i=1; i<dl; i++){
            result[i] = 0;
        }
        result[0] = 1;
        return result;
    }
}

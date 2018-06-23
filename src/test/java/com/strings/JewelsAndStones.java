package com.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangwei on 2018/5/15.
 *
 S中有多少个字符是在J中存在的。
 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 */
public class JewelsAndStones {

    public int myNumJewelsInStones(String J, String S) {
        char[] chars = J.toCharArray();
        char[] sc = S.toCharArray();
        Set<String> set = new HashSet<String>();
        for(char c:chars){
            set.add(String.valueOf(c));
        }
        int result = 0;
        for(char c:sc){
            if(set.contains(String.valueOf(c))){
                result++;
            }
        }
        return result;
    }



}

package com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/25.
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:
 输入: s = "anagram", t = "nagaram"
 输出: true

 示例 2:
 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class ValidAnagram {

    //beats 90.45%
    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        final char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    //beats 5.86%
    public boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }

        Map<String,Integer> sMap = new HashMap<String,Integer>();

        for (String c : s.split("")){
            //todo jdk 升级
            //sMap.put(c,sMap.getOrDefault(c,0)+1);
        }

        for (String ch : t.split("") ){

            if (sMap.containsKey(ch)&&sMap.get(ch)>=1){
                sMap.put(ch,sMap.get(ch)-1);
            }else {
                return false;
            }
        }
        return true;
    }
}

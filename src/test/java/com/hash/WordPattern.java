package com.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangwei on 2018/5/21.
 * 给定一个模式s和一个str，验证str是否是给定模式的str
 * 模式s是小写，str是小写且由空格分隔
 *
 Example 1:

 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true
 Example 2:

 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false
 Example 3:

 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false
 Example 4:

 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 */
public class WordPattern {

    public static void main(String[] s){
        new WordPattern().myWordPattern("abba", "dog cat cat dog");
        new WordPattern().myWordPattern("abba", "dog dog dog dog");
    }

    //wrong, "abba", "dog dog dog dog"，只考虑来k-v的情况，没有考虑不同k对应相同v的情况
    public boolean myWordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(chars.length != strs.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            String s = strs[i];
            if(map.containsKey(c)){
                if(!s.equals(map.get(c))){
                    return false;
                }
            }else {
                map.put(c, s);
            }
        }
        return true;
    }

    //beats 96.42%
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i) {
            //map.put方法的返回值有两种情况，1：key不存在返回null，2：key存在返回put前这个key保持的value值
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
            /*Object o = index.put(pattern.charAt(i), i);
            Object b = index.put(words[i], i);
            if(o != b){
                return false;
            }*/
        }
        return true;
    }

    //beats 96.42% ？？
    public boolean wordPattern2(String pattern, String str) {
        String[] arr = str.split(" ");
        int len=arr.length;
        if(len!=pattern.length())
            return false;
        Map<Character, String> hash = new HashMap<Character, String>();
        for(int i=0; i<len; i++) {
            char ch=pattern.charAt(i);
            if(hash.containsKey(ch)) {
                if(!hash.get(ch).equals(arr[i]))
                    return false;
            } else {
                if(hash.containsValue(arr[i]))
                    return false;
                hash.put(ch, arr[i]);
            }
        }
        return true;
    }

    //beats 96.42%
    public boolean wordPattern3(String pattern, String str) {

        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;

        Map<Character, String> charToWord = new HashMap<Character, String>();
        Set<String> mapped = new HashSet<String>();

        char[] ch = pattern.toCharArray();
        String[] words = str.split(" ");
        if(ch.length != words.length) return false;

        for(int i=0; i < ch.length; i++){
            if(charToWord.containsKey(ch[i])){
                if(!charToWord.get(ch[i]).equals(words[i]))
                    return false;
            }else{
                charToWord.put(ch[i], words[i]);
                if(!mapped.add(words[i]))
                    return false;
            }
        }
        return true;
    }

}

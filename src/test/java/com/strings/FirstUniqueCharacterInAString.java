package com.strings;

import java.util.*;

/**
 * Created by zhangwei on 2018/5/26.
 * 字符串中的第一个唯一
 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:
 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.

 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] s){
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
    }

        //wrong
    public int myFirstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        char[] singles = new char[chars.length];
        int sc = 1;
        char temp = chars[0];
        singles[0] = temp;
        for(int i=1; i<chars.length; i++){
            if(chars[i] == temp){
                sc--;
            }else {
                temp = chars[i];
                singles[sc++] = temp;
            }
        }
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<sc; i++){
            set.add(singles[i]);
        }
        for(int i=0; i<chars.length; i++){
            if(set.contains(chars[i])){
                return i;
            }
        }
        return -1;
    }

    //beats 27.02%
    public int myFirstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : chars){
            if(map.containsKey(c)){
                map.put(c, 1);
            }else {
                map.put(c, 0);
            }
        }

        for(int i=0; i<chars.length; i++){
            if(map.get(chars[i]) == 0){
                return i;
            }
        }
        return -1;
    }

    //beats 77.02%
    public int firstUniqChar(String s) {
        if(s==null||s.length()<1)return -1;
        char[] cs=s.toCharArray();
        //用26位的数组表示26个字母，每一位代码出现几次，如果是1，即是出现一次的情况
        int[] map=new int[26];
        //将每个字母都填充进去
        for(char c: cs){
            map[(int)c-97]++;
        }
        //找出第一个1的情况并返回
        for(int i=0,len=s.length();i<len;i++){
            if(map[(int)cs[i]-97]==1)return i;
        }
        return -1;
    }

    //beats 85.35%
    public int firstUniqChar5(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] alphabets = new int[26];
        char[] charStr = s.toCharArray();

        for (int i=0; i<charStr.length;i++) {
            char curChar = charStr[i];
            if (alphabets[curChar - 'a'] == 0) {
                alphabets[curChar -'a'] = i+1;
            } else if (alphabets[curChar - 'a'] > 0) {
                alphabets[curChar - 'a'] = -1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<alphabets.length;i++) {
            if (alphabets[i] > 0) {
                min = Math.min(min, alphabets[i]);
            }
        }

        return min == Integer.MAX_VALUE? -1 : min - 1;
    }

    //beats 79.84%
    public int firstUniqChar4(String s) {
        int[] store = new int[26];
        for (char c : s.toCharArray()){
            store[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (store[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return - 1;
    }

    //beats 74.87%
    public int firstUniqChar1(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    //beats 62.63%
    public static int firstUniqChar2(String s) {

        char[] a = s.toCharArray();

        for(int i=0; i<a.length;i++){
            if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
        }
        return -1;
    }

    //beats 66.4%
    public int firstUniqChar3(String s) {
        int firstOccrence=0, secondOccrence = 0;
        for(char c : s.toCharArray()){
            if(getBit(c-'a',firstOccrence)){
                secondOccrence = setBit(c-'a',secondOccrence);
            } else {
                firstOccrence = setBit(c-'a',firstOccrence);
            }
        }

        //System.out.println(Integer.toBinaryString(secondOccrence));
        for(int i=0; i<s.length();i++){
            if(!getBit(s.charAt(i) - 'a',secondOccrence))
                return i;
        }

        return -1;
    }

    public boolean getBit(int index, int number){
        return (number & (1 << index)) != 0;
    }

    public int setBit(int index, int number){
        return number |= (1 << index);
    }
}

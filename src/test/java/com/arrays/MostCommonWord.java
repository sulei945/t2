package com.arrays;

import java.util.*;

/**
 * Created by zhangwei on 2018/5/16.
 * 给定一个字符串，有字母空格和标点符合组成，字母不区分大小写
 * 给定一个禁止次列表
 * 给出字符串中出现频率最高的非禁止词
 */
public class MostCommonWord {

    public static void main(String[] s){
        System.out.println("1234".substring(0, 3));
        new MostCommonWord().myMostCommonWord("Bob hit a ball\n" +
                "the hit BALL flew far after it was hit.", new String[]{"hit"});
    }

    public String myMostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(banned));
        dealStr(paragraph, map, set);

        int max = Integer.MIN_VALUE;
        String result = null;
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private void dealStr(String str, Map<String, Integer> map, Set<String> banned){
        String[] strs = str.split(" ");
        for(String s:strs){
            if(s == null || s.length() == 0) continue;
            while (true){
                char c = s.charAt(s.length()-1);
                if(Character.isLetter(c)){
                    s = s.toLowerCase();
                    if(!banned.contains(s)){
                        Integer si = map.get(s);
                        if(si == null){
                            si = 1;
                        }else {
                            si++;
                        }
                        map.put(s, si);
                    }
                    break;
                }else {
                    s = s.substring(0, s.length()-1);
                }
            }
        }
    }

    /*public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }*/
}

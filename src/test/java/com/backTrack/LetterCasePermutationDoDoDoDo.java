package com.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/5/15.
 给定一个字符串，通过更改字符串的字母大小写更改为另一个字符串，列出所有的可能值
 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 回溯算法( BackTrack )在算法过程中就是类似于枚举算法，尝试在搜索过程中找到问题的解。
 全排列问题，子集问题，组合和问题都是经典的回溯问题。
 https://segmentfault.com/a/1190000012867726
 https://blog.csdn.net/christiger22/article/details/63327263
 */
public class LetterCasePermutationDoDoDoDo {
    public List<String> letterCasePermutation(String S) {
        Queue<String> r = new LinkedList<String>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {//分析字符串每一个字符
            char c = S.charAt(i);
            if (Character.isLetter(c)) {//如果该字符为英文字符，继续执行
                int size = r.size();
                for (int j = 0; j < size; j++) {//队列内存放目前为止各种情况
                    String s = r.poll();//每一次弹出一个保存的String
                    r.add(s.substring(0, i) + Character.toLowerCase(c) + s.substring(i + 1));
                    r.add(s.substring(0, i) + Character.toUpperCase(c) + s.substring(i + 1));
                    //弹出后将该字符串的当前位置字符分别替换为大小写，保存到队列中
                }
            }
        }
        return (List)r;
    }

    //wrong
    public List<String> myletterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        int sl = S.length();
        if(S == null) return result;
        result.add(S.toLowerCase());
        if(S.length() == 0) return result;

        char[] chars = S.toCharArray();

        List<Integer> strList = new ArrayList<Integer>();
        for(int i=0; i<chars.length; i++){
            if(!Character.isDigit(chars[i])){
                strList.add(i);
            }
        }

        for(int i=1; i<=strList.size(); i++){
            for(int j=0; j<=strList.size()-i; j++){
                String t = result.get(0);
                for(int n = 0; n<strList.size()-i-j; n++){
                    for(int k=0; k<i; k++){
                        int x = strList.get(j+k+n);
                        String a = t.substring(0, x);
                        String b = String.valueOf(t.charAt(x)).toUpperCase();
                        String c = t.substring(x+1, sl);
                        t = t.substring(0, x) + String.valueOf(t.charAt(x)).toUpperCase() + t.substring(x+1, sl);

                    }
                }
                result.add(t);
            }
        }
        return result;
    }

    //wrong
    public List<String> myletterCasePermutation2(String S) {
        List<String> result = new ArrayList<String>();
        int sl = S.length();
        if(S == null) return result;
        result.add(S.toLowerCase());
        if(S.length() == 0) return result;

        char[] chars = S.toCharArray();

        List<Integer> strList = new ArrayList<Integer>();
        for(int i=0; i<chars.length; i++){
            if(!Character.isDigit(chars[i])){
                strList.add(i);
            }
        }

        for(int i=0; i<strList.size(); i++){
            for(int j=0; j<strList.size()-i; j++){
                int k = i+1;
                String t = result.get(0);
                while (k > 0){
                    int x = strList.get(j+k-1);
                    String a = t.substring(0, x+1);
                    String b = String.valueOf(t.charAt(x)).toUpperCase();
                    String c = t.substring(x+1, sl);
                    t = t.substring(0, x) + String.valueOf(t.charAt(x)).toUpperCase() + t.substring(x+1, sl);
                    k--;
                }
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] s) {
        new LetterCasePermutationDoDoDoDo().letterCasePermutation("mQe");
        new LetterCasePermutationDoDoDoDo().letterCasePermutation("a1b2");
    }
}

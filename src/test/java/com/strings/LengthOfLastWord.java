package com.strings;

import com.tree.SymmetricTree;

/**
 * Created by zhangwei on 18-5-28.
 * 最后一个单词的长度
 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5
 */
public class LengthOfLastWord {

    public static void main(String[] s){
        int i = 10;
        while(9005/i > 0){
            i*=10;
        }
        i/=100;
        System.out.println(i);
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
    }

    //beats 94.38%
    public int lengthOfLastWord(String s) {
        int l = s.length()-1;
        int r = 0;
        while (l >= 0){
            if(s.charAt(l) != ' '){
                r++;
            }else if(r != 0){
                break;
            }
            l--;
        }

        return r;
    }


    //beats 39.36%
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ")+1).length();
    }
}

package com.strings;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhangwei on 2018/5/23.
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 */
public class ValidParentheses {

    public static void main(String[] s){
        Stack stack = new Stack();  //extends Vector !!!
        new ValidParentheses().isValid("{[]}");
    }

    //beats 98.88%
    public boolean isValid(String s) {
//        if(s.length() % 2 == 1) return false;
        //没有这行 //beats 84.95%
        if(s.length() == 2) return s.equals("()") || s.equals("{}") || s.equals("[]");
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<Character>();
        for (int i = 0; i<chars.length; i++){
            char c = chars[i];
            if(c == '(' || c=='[' || c== '{'){
                queue.offer(chars[i]);
            }else {
                if(queue.isEmpty()) return false;
                char l = queue.removeLast();
                if(!((l == '(' && c == ')')
                        || (l == '[' && c == ']')
                        || (l == '{' && c == '}'))){
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

    //beats 33.65%
    public boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<Character>();
        for (int i = 0; i<chars.length; i++){
            if(isLeft(chars[i])){
                queue.offer(chars[i]);
            }else if(queue.isEmpty() || !isClose(queue.removeLast(), chars[i])){
                return false;
            }
        }
        return queue.isEmpty();
    }
    private boolean isLeft(char c){
        return c == '(' || c=='[' || c== '{';
    }

    private boolean isClose(char l, char r){
        return (l == '(' && r == ')')
                || (l == '[' && r == ']')
                || (l == '{' && r == '}');
    }
}

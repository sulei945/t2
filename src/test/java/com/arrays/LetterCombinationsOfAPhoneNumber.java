package com.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangwei on 2018/4/27.
 */
// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 通过输入的数组，给出可能的字符串组合（手机九宫格键盘输入法）
public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {
        // 下面不难
        String[] context = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        char[] intChar = digits.toCharArray();

        return null;
    }
}

package com.binarySearch;

/**
 * Created by zhangwei on 2018/5/21.
 * 从给定的数组中找出比目标字符大的字符中最小的那个。如果不存在返回第一个。
 * Examples:
 Input:
 letters = ["c", "f", "j"]
 target = "a"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "c"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "d"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "g"
 Output: "j"

 Input:
 letters = ["c", "f", "j"]
 target = "j"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "k"
 Output: "c"
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] s){
        new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'a');
    }

    //wrong
    public char myNextGreatestLetter(char[] letters, char target) {
        int f = 0;
        int t = letters.length-1;
        while (f<=t){
            int m = (f+t)/2;
            /*
            if(letters[m] == target){   //不可以，每考虑重复元素的情况
                if(m < letters.length-1){
                    return letters[m+1];
                }else {
                    return letters[0];
                }
            }else*/
            if(letters[m] < target){
                f = m+1;
            }else{
                t = m-1;
            }
        }
        if(f > t && t >=0) f = t;
        if(letters[f] != target) return letters[f];
        return f == letters.length-1 ? letters[0] : letters[f+1];
    }

    //beats 98.84%
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int i = 0, j = n - 1;

        // i <= j, because when i == j, letters[i] may equals target, we need to move to next element
        while(i <= j)
        {
            int m = i + (j - i) / 2;    //??
            if(letters[m] <= target)
                i = m + 1;
            else
                j = m - 1;
        }

        //if i == n, we cannot find the element larger than the target
        //letters[0] is the next round of the element
        return i == n ? letters[0] : letters[i];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }
}

package com.arrays;

/**
 * Created by zhangwei on 2018/5/15.
 *
 Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 Output: True
 Explanation:
 1234
 5123
 9512
 In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
 and in each diagonal all elements are the same, so the answer is True.
 */
public class ToeplitzMatrix {

    //基本想法就是遍历每一个元素，同时比较这个元素和它右下角元素的值是否相等，如果不相等，直接返回false，停止遍历。
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length-1;
        int y = matrix[0].length-1;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }



    //有问题
    public boolean isToeplitzMatrix2(int[][] matrix) {
        if(matrix == null) return false;
        int x = matrix.length;
        if(x == 0) return false;
        int y = matrix[0].length;
        for(int i=0; i<y; i++){
            int z = matrix[0][i];
            int k = i+1;
            for(int j=i+1; j<x && k<y; j++,k++){
                if(z !=matrix[j][k]){
                    return false;
                }
            }
        }
        for(int i=1; i<x; i++){
            int z = matrix[i][0];
            int k = i+1;
            for(int j=i; j<y && k<x; j++,k++){
                if(z != matrix[k][j]){
                    return false;
                }
            }
        }

        return true;
    }
}


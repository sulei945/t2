package com.sort;

/**
 * Created by zhangwei on 2018/1/22.
 * 首先从未排序序列中找到最小的元素，放置到排序序列的起始位置，然后从剩余的未排序序列中继续寻找最小元素，
 * 放置到已排序序列的末尾。所以称之为选择排序。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }

        arr = sort(arr);

        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

    public static int[] sort(int[] arr){
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int min = i;
            for(int j = min + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[min]){
                    min = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != min){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}

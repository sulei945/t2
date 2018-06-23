package com.sort;

/**
 * Created by zhangwei on 2018/1/22.
 * 冒泡排序
 * 依次比较相邻的两个元素，如果第一个元素大于第二个元素就交换它们的位置。这样比较一轮之后，最大的元素就会跑到队尾。
 * 然后对未排序的序列重复这个过程，最终转换成有序序列。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        arr = sort(arr);

        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少个元素
                if (arr[j] > arr[j + 1]) {
                    /*int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;*/

                    //少用一个内存空间
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
        return arr;
    }
}

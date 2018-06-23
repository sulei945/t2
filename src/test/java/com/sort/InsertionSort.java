package com.sort;

/**
 * Created by zhangwei on 2018/1/25.
 *
 认为第一个元素是排好序的，从第二个开始遍历。
 拿出当前元素的值，从排好序的序列中从后往前找。
 如果序列中的元素比当前元素大，就把它后移。直到找到一个小的。
 把当前元素放在这个小的后面（后面的比当前大，它已经被后移了）。

 */
public class InsertionSort {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        insertionSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }
}

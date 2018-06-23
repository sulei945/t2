package com.arrays;

/**
 * Created by zhangwei on 2018/4/2.
 * 二分查找／折半查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
        System.out.println("递归查找:" + binarySearch(arr, 87, 0, arr.length - 1));
    }


    //递归实现二分查找
    public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
        if(beginIndex >= endIndex) return -1;
        int curIndex = (beginIndex + endIndex)/2;
        int c = dataset[curIndex];
        if(c == data){
            return curIndex;
        }else if(c < data){
            return binarySearch(dataset, data, beginIndex, curIndex-1);
        }else{
            return binarySearch(dataset, data, curIndex+1, endIndex);
        }
    }

    //循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
    public static int binarySearch(int[] arr, int x) {
        int mid;
        int from = 0;
        int to = arr.length - 1;
        while (from <= to) {
            mid = (from + to) / 2;
            int c = arr[mid];
            if (c == x) {
                return mid;
            } else if (c < x) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return -1;
    }

}

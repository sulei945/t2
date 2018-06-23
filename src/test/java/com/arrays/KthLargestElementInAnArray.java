package com.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhangwei on 2018/4/20.
 */
// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.
//在一个数组中找到第k大的数字。
public class KthLargestElementInAnArray {

    //1.Sorting O(nlog(n))
    public int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //2.Quick Sort Average case time is O(n), worst case time is O(n^2).
    public int findKthLargestQuickSort(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }


    //3.适用优先队列处理，将队列里放k个数据，之后再放的时候只放比队列里最小值还要大的数据，并保持队列不要超过k个元素
    // We can use a min heap to solve this problem.
    // The heap stores the top k elements. Whenever the size is greater than k, delete the min. Time complexity is O(nlog(k)).
    // Space complexity is O(k) for storing the top k numbers.
    public int findKthLargestHeap(int[] nums, int k) {
        /**
         *  initialCapacity 参数只是指定初始时PriorityQueue的底层Object数组的大小，不是指定PriorityQueue的队列大小
         *  因此这里设置k+1，正好配合下面的q.poll方法，保证最大使用率且不会产生Object数组扩容的情况
         */
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k+1);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String[] s){
        new KthLargestElementInAnArray().findKthLargestHeap(new int[]{1,4,3,2}, 2);
    }

}

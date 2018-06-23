package com.sort;

/**
 * Created by zhangwei on 2018/1/22.
 * 快速排序是冒泡排序的改进版，也是最好的一种内排序，在很多面试题中都会出现，也是作为程序员必须掌握的一种排序方法。

 思想:1.在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；

 2.将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；

 3.对左右两个分区重复以上步骤直到所有元素都是有序的。

 所以我是把快速排序联想成东拆西补或西拆东补，一边拆一边补，直到所有元素达到有序状态。

 */
public class QuickSortDoDoDoDoDoDo {
    public static void quickSort(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while(left != right){   //从左右两边交替扫描，直到left = right

                while(right > left && arr[right] >= temp)
                    right --;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

                while(left < right && arr[left] <= temp)
                    left ++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            arr[right] = temp;    //基准元素归位
            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
        }
    }
    public static void main(String[] args) {
        int array[] = {10,5,3,1,7,2,8};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }

        quickSort(array,0,array.length-1);

        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }


        System.out.println("----------------");
        quickSort(array);
    }

    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端

            //交换位置后，hight和low都不做偏移都原因是用来下次发现可以交换都元素来覆盖用。
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}

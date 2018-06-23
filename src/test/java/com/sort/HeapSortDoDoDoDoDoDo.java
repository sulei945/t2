package com.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2018/4/25.
 *  最大堆 特点：父节点大于等于儿子结点。
 *  所以最大堆的特点是，任何一个结点的值都比它的所有子结点都大
 */
public class HeapSortDoDoDoDoDoDo {

    public static void main(String[] args) {


        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data5);
        heapSort(data5);
        System.out.println("排序后的数组：");
        print(data5);


        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        heapSort2(a);
        System.out.println(Arrays.toString(a));


        //todo------------------------下面的可能有问题------------------------------------------------------------
        Heap heap = new Heap();
        heap.setA(Arrays.asList(51, 46, 20, 18, 65, 97, 82, 30, 77, 50));
        HeapSort(heap);
        System.out.println(Arrays.toString(heap.A.toArray()));
    }

    //----------------------------------------------------------------------------------------------------------------
    public static void heapSort(int[] data) {
        // 创建最大堆，并将最大值下沉，缩小范围后继续循环处理，每一次循环都是找到最大值并下沉的过程，所以要执行数组大小次循环
        for (int i = 0; i < data.length-1; i++) {
            createMaxdHeap(data, data.length - 1 - i);
            // 将最大堆的根元素与最后一个结点交换，实现最大值下沉
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }
    /**
     * 最大堆 数组的表示方式，第一个元素存的是树的根，第二个是根的左结点，第三个是右结点，依次往隔层表示
     * 最大堆 特点是每个结点都不小于它的任何子结点，这样根结点就是最大值，即第一个元素是最大值。
     * 堆排序就利用根是最值的特点，将创建堆的过程就是找到最值的过程，每次将最值下沉后缩小堆范围不断处理
     */
    public static void createMaxdHeap(int[] data, int lastIndex) {
        // 遍历所有非叶子结点将最大的值向跟结点转移，保证满足最大堆条件。
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点存在子节点，将当前结点的值和它的子结点的值比较，将最大的值放在当前结点位置
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                if (biggerIndex < lastIndex) {
                    // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    //因为将k和biggerIndex的值进行交换后，是将较大的子结点的值与较小的父节点的值交换，
                    // 这可能会破坏之前的最大推结构，需要将k赋值成biggerIndex，继续判断是否影响了下面的最大堆规则，
                    // 配合上面的while将破坏的情况再次修正好
                    k = biggerIndex;
                } else {
                    // 每个结点只有两个子结点，biggerIndex是两个里最大的，所以当前结点如果比最大的还大则不需要交换，跳出循环
                    break;
                }
            }
        }
    }

    // 交换两个节点的值
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    // 打印当前数组的值
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

//----------------------------------------------------------------------------------------------------------------


    public static void heapSort2(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }

    /**
     * 构建大顶堆
     */
    private static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i ; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }


//--------------------------------------------下面的先忽略，有问题--------------------------------------------------------------------

    /**
     * 新建一个类来表示堆：
     * 没有使用数组的原因是，java里数组初始化以后就不能再添加元素了，在讲解后面内容的时候会有所不方便。
     *
     * 堆是一种数据结构，你可以把他看成一颗完全二叉树,底层存储适用数组。
     * 根结点是Array[0],后面每层的结点一次填满，所以第二层的两个元素为Array1，Array2，第三层为Array3456。
     * 由此得出left，right，parent方法。
     */
    static class Heap {

        private List<Integer> A;

        private int heapSize;

        public List<Integer> getA() {
            return A;
        }

        public void setA(List<Integer> a) {
            A = a;
        }

        public int getHeapSize() {
            return heapSize;
        }

        public void setHeapSize(int heapSize) {
            this.heapSize = heapSize;
        }

        // 左节点下标
        public int left(int i) {
            return i * 2 + 1;
        }

        // 右节点下标
        public int right(int i) {
            return i * 2 + 2;
        }

        // 父节点下标
        public int parent(int i) {
            return (i - 1) / 2;
        }
    }

    /**
     * 堆排序算法
     * 先用BuildMaxHeap把输入的数组A构造成最大堆。
     * 然后，把下标heapSize - 1的元素和下标为0的元素对换，通过减小heapSize，让下标为heapSize - 1的元素从堆中剔除，
     * 再调用MaxHeapify（heap, 0）即可保证最大堆的性质。
     * 重复这个过程，直到堆中只剩下一个元素。
     * @param heap 堆
     */
    private static void HeapSort(Heap heap) {
        BuildMaxHeap(heap);
        int length = heap.getA().size(), heapSize = heap.getHeapSize();
        for (int i = length - 1; i > 0; i--) {
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(0));
            heap.getA().set(0,temp);
            heap.setHeapSize(--heapSize);
            MaxHeapify(heap, 0);
        }
    }

    /**
     * 构建最大堆
     * 建堆的过程：从下标heapSize - 1开始，对每个结点都执行MaxHeapify就行了，
     * 但是叶子结点由于没有子结点，所以只需要从（heapSize - 1）/2开始，对每个结点都执行MaxHeapify就行了
     * @param heap 堆
     */
    private static void BuildMaxHeap(Heap heap) {
        int heapsize = heap.getHeapSize();
        for (int i = (heapsize - 1) / 2; i>= 0; i--) {
            MaxHeapify(heap, i);    //递归版
            //MaxHeapifyNoRecursive(heap, i);
        }
    }

    /**
     * 递归实现的堆排序
     * 当儿子结点大于父节点的时候，就失去了最大堆的性质，所以在这个时候，我们只要把儿子结点和父结点交换，
     * 但是交换以后，被交换的父结点的儿子结点发生了变化，可能会继续违背最大堆这个性质，所以要递归调用这个算法。
     * @param heap 堆
     * @param i 当前坐标
     */
    private static void MaxHeapify(Heap heap, int i) {
        int l = heap.left(i);
        int r = heap.right(i);
        int largest = i;
        if (l < heap.getHeapSize() && heap.getA().get(l) > heap.getA().get(i)) {
            largest = l;
        }
        if (r < heap.getHeapSize() && heap.getA().get(r) > heap.getA().get(largest)) {
            largest = r;
        }
        if (largest != i) {
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(largest));
            heap.getA().set(largest, temp);
        } else
            return;
        MaxHeapify(heap, largest);
    }

    /**
     * 非递归实现的堆排序，可以提升效率
     * @param heap 堆
     * @param i 当前坐标
     */
    private static void MaxHeapifyNoRecursive(Heap heap, int i) {
        while (true) {
            int l = heap.left(i);
            int r = heap.right(i);
            int heapSize = heap.getHeapSize();
            List<Integer> A = heap.getA();
            int largest = i;
            if (l < heapSize && A.get(l) > A.get(i)) {
                largest = l;
            }
            if (r < heapSize && A.get(r) > A.get(largest)) {
                largest = r;
            }
            if (largest != i) {
                int temp = A.get(i);
                A.set(i, A.get(largest));
                A.set(largest, temp);
            } else
                return;
            i = largest;
        }
    }
}

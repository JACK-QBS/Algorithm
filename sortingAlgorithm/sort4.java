package sort;

import java.util.Arrays;

//堆排序
public class sort4 {
    public static void heapSort(long[] array) {
        //1、建大堆
        createHeap(array,array.length);
        //2、进行选择的过程，一共需要 array.length - 1组
        for (int i = 0; i < array.length - 1; i++) {
            //无序区间：[ 0,array.length - 1]
            //交换0号下标（大堆中0号下标为堆中最大值）和无序数组中最后一个元素
            long t = array[0];
            array[0] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
            // 无序区间变为：[ 0,array - i - 1]
            //向下调整
            adjustDown(array,array.length-1-i,0);
        }
    }
    //建大堆
    private static void createHeap(long[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustDown(array,size,i);
        }
    }
    //向下调整
    private static void adjustDown(long[] array, int size, int index) {
        while (true) {
            //1、判断该结点是不是叶子结点
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                //左孩子不存在，该节点是叶子结点
                return;
            }
            //2、找出最大的孩子
            int maxIndex = leftIndex;
            int rightIndex = 2 * index + 2;
            if (rightIndex < size && array[rightIndex] > array[maxIndex]) {
                maxIndex = rightIndex;
            }
            //3、比较最大孩子和该节点的大小
            if (array[index] >= array[maxIndex]) {
                //当前结点的值大于两个孩子的值，则无须交换
                return;
            }
            //4、交换
            long t = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = t;
            //5、将最大孩子视为 index，循环回去
            index = maxIndex;
        }
    }
    public static void main(String[] args) {
        long[] a1 = new long[]{20,17,16,5,4,3};
        System.out.println(Arrays.toString(a1));
        heapSort(a1);
        System.out.println(Arrays.toString(a1));
    }

}

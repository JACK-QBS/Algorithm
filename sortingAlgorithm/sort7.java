package sort;

import java.util.Arrays;
import java.util.Random;

//归并排序
public class sort7 {
    public static void mergeSort(long[] array) {
        mergeSortInternal(array,0,array.length);
    }
    //区间范围时左闭右开的
    // array[lowIndex,highIndex ]
    private static void mergeSortInternal(long[] array, int lowIndex, int highIndex) {
        int size = highIndex - lowIndex;
        if (size <= 1) {
            return;
        }
        int midIndex = (highIndex + lowIndex) / 2;
        // 左区间：[lowIndex,midIndex)
        // 右区间：[midIndex,highIndex)
        mergeSortInternal(array,lowIndex,midIndex);
        mergeSortInternal(array,midIndex,highIndex);
        // 左右两个区间有序，进行合并
        mergeOrderedIntervals(array,lowIndex,midIndex,highIndex);
    }
    // 新建一个额外数组，将需要合并的两个数组中依次取出元素进行比较，在放入额外数组中
    private static void mergeOrderedIntervals(long[] array, int lowIndex, int midIndex, int highIndex) {
        int size = highIndex - lowIndex;//新数组长度
        long[] extra = new long[size];
        int leftIndex = lowIndex;//左边数组的下标
        int rightIndex = midIndex;//右边数组的下标
        int i = 0;//新数组下标
        // 两个数组中都有元素
        while (leftIndex < midIndex && rightIndex < highIndex) {
            // <= 保证稳定性
            if (array[leftIndex] <= array[rightIndex]) {
                extra[i] = array[leftIndex];
                leftIndex++;
            } else {
                extra[i] = array[rightIndex];
                rightIndex++;
            }
            i++;
        }
        // 已经有数组空了，则将另外一个数组全部放入新数组中
        if (leftIndex < midIndex) {
            //右边数组为空
            while (leftIndex < midIndex) {
                extra[i++] = array[leftIndex++];
            }
        } else {
            //左边数组为空
            while (rightIndex < highIndex) {
                extra[i++] = array[rightIndex++];
            }
        }
        //在将原数组中的值换为新数组的值
        for (int j = 0; j < size; j++) {
            array[lowIndex + j] = extra[j];
        }
    }


    public static long[] randomArray() {
        Random random = new Random(20201018);
        long[] array = new long[10];
        for (int i = 0; i < 10; i++) {
            //放 100 以内的随机数
            array[i] = random.nextInt(100);
        }
        return array;
    }
    public static void main(String[] args) {
        //long[] a1 = new long[]{5,3,1,9,2,8,7,6};
        long[] a1 = randomArray();
        System.out.println(Arrays.toString(a1));
        mergeSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}

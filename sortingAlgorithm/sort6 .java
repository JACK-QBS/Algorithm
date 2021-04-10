package sort;

import java.util.Arrays;
import java.util.Random;

//快排
public class sort6 {
    public static void quickSort(long[] array) {
        quickSortInternal(array,0,array.length - 1);
    }

    private static void quickSortInternal(long[] array, int lowIndex, int highIndex) {
        //4、区间内的个数 = 0 / 1时，结束
        int size = highIndex - lowIndex + 1;
        if (size <= 1) {
            return;
        }
        //1、选出一个数（选择最左边的）- array[lowIndex]
        //2、执行 partition，小的放左，大的放右
        //keyIndex 是经过 partition之后，选出来的数最终所在的下表
        int keyIndex = partition(array,lowIndex,highIndex);
        //3、分别对左右区间进行相同处理 - 递归
        quickSortInternal(array,lowIndex,keyIndex - 1);
        quickSortInternal(array,keyIndex + 1,highIndex);
    }

    //以选出的 lowIndex 位置下的元素为基准，遍历数组，把比基准元素小的放到他左边，比他大的放右边
    private static int partition(long[] array, int lowIndex, int highIndex) {
        //选择合适的方法:
        //return hover(array,lowIndex,highIndex);
        //return digAHole(array,lowIndex,highIndex);
        return doublePointer(array,lowIndex,highIndex);
    }

    //方法2：挖坑法
    private static int digAHole(long[] array, int lowIndex, int highIndex) {
        //key 代表基数，将其挖出，则该位置为空
        long key = array[lowIndex];
        int leftIndex = lowIndex + 1;
        int rightIndex = highIndex;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            //把右边小于基数的那个数填到之前左边挖出的坑中
            array[lowIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] < key) {
                leftIndex++;
            }
            //把左边大于基数的那个数填到上边空出的那个位置
            array[rightIndex--] = array[leftIndex++];
        }
        array[rightIndex] = key;
        return rightIndex;
    }

    //方法3：前后遍历法：
    private static int doublePointer(long[] array, int lowIndex, int highIndex) {
        int separateIndex = lowIndex + 1;
        for (int i = lowIndex + 1; i <= highIndex; i++) {
            if (array[i] < array[lowIndex]) {
                swap(array,i,separateIndex);
                separateIndex++;
            }
        }
        swap(array,lowIndex,separateIndex - 1);
        return separateIndex - 1;
    }
    private static void swap(long[] array,int index1,int index2) {
        long t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }

    //方法1：Hover
    private static int hover(long[] array, int lowIndex, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        // 选择的数是最左边的一个
        long key = array[lowIndex];
        //选择了最左边，从右边开始
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            //rightIndex下标遇到比基数小的数，leftIndex下标遇到比基数大的数，则，交换两个数字
            swap(array,leftIndex,rightIndex);
        }
        //
        swap(array,lowIndex,leftIndex);
        return leftIndex;
    }

    public static void main(String[] args) {
        long[] a1 = new long[]{5,3,1,9,2,8,7,6};
        System.out.println(Arrays.toString(a1));
        quickSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}

package sort;

import java.util.Arrays;

//希尔排序
public class sort5 {
    public static void shellSort(long[] array) {
        //gap为间隔，也就是分为了几组
        int gap = array.length / 2;
        while (true) {
            insertSortGap(array,gap);
            if (gap == 1) {
                break;
            }
            //下次的组数为上次组数的一半
            gap = gap / 2;
        }
    }
    public static void insertSortGap(long[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            // key 为同一组中的第二个数
            long key = array[i];
            int j = 0;
            //同一组中的第一个数
            for (j = i - gap; j >= 0; j = j -gap) {
                //第二个数 < 第一个数
                if (key < array[j]) {
                    //第二个数的值 = 第一个数的值
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            //第一个数 = 之前保存的第二个数的值（此时的 j 是一个负数，加上 gap 刚好为第一个数）
            array[j + gap] = key;
        }
    }

    public static void main(String[] args) {
        long[] a1 = new long[]{20,17,16,5,4,3};
        System.out.println(Arrays.toString(a1));
        shellSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}

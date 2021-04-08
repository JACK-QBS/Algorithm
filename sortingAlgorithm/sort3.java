package sort;

import java.util.Arrays;
import java.util.Random;

//选择排序
public class sort3 {
    public static void selectSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序区间：[0,i]
            //无序区间：[i + 1,array.length - 1]
            int minIndex = i;//最小数下标
            //先从无序区间中找到最小的数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换这个 最小数 和 有序区间的最后一个数
            long t = array[minIndex];
            array[minIndex] = array[i];
            array[i] = t;
        }
    }

    //1、随机生成的乱序数
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
        long[] a1 = randomArray();
        System.out.println(Arrays.toString(a1));
        selectSort(a1);
        System.out.println(Arrays.toString(a1));
    }


}

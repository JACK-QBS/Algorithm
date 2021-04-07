package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort1 {
    //插入排序
    public static void insertSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //1、抓无序区间第一张牌(红色牌)
            long key = array[i + 1];
            //2、将取出的牌依次和有序区间的牌比较
            int j;
            for (j = i; j >= 0; j--) {
                //如果取出 红色的牌的值 < 绿色牌的值
                if (key < array[j]) {
                    //将 绿牌 往后挪一个位置
                    array[j + 1] = array[i];
                } else {
                    break;
                }
            }
            //3、选择合适的位置插入
            array[j + 1] = key;
        }
    }

    /**
     * 测试：
     * 1、随机生成的乱序数
     * 2、已经有序
     * 3、逆序
     * 4、数组内容完全相等
     */

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

    //2、构建完全有序数组
    public static long[] orderArray() {
        long[] array = randomArray();
        Arrays.sort(array);
        return array;
    }

    //3、构建逆序数组
    public static long[] reverseOrderArray() {
        long[] array = orderArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            long t = array[left];
            array[left] = array[right];
            array[right] = t;
            left++;
            right--;
        }
        return array;
    }

    //4、构建完全相等的数组
    public static long[] equalArrays() {
        long[] array = new long[10];
        for (int i = 0; i < 10; i++) {
            array[i] = 9;
        }
        return array;
    }


    public static void main(String[] args) {
        long[] a1 = randomArray();
        System.out.println(Arrays.toString(a1));
        insertSort(a1);
        System.out.println(Arrays.toString(a1));
    }

}

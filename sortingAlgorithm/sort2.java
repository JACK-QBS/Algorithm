package sort;

//冒泡排序
public class sort2 {
    public static void bubbleSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //无序区间：[0,array.length - 1]
            //有序区间：[array.length - i,array.length]

            //每次进行冒泡之前，假设数组已经有序
            boolean isSorted = true;
            //进行冒泡过程
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    long t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}

package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// long类型数字转换成 int数组
public class change {
    public static int[] longChangeInt(long n) {
        Deque stack = new LinkedList();
        while (n > 0) {
            int s = (int)(n % 10);
            stack.push(s);
            n /= 10;
        }
        int[] array = new int[stack.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) stack.pop();
        }
        return array;
    }

    public static void main(String[] args) {
        long n = 20210408;
        int[] arr = longChangeInt(n);
        System.out.println(Arrays.toString(arr));
    }
}

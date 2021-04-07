package test;

import java.util.Scanner;

public class baseConversion {
    //计算 n 的 p 次方
    public static long pow(int n,int p) {
        long r = 1;
        for (int i = 0; i < p; i++) {
            r *= n;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexString = scanner.nextLine();//十六进制字符串
        long n = hexToTen(hexString);

        System.out.println(n);
    }

    //十六进制转十进制
    private static long hexToTen(String hexString) {
        long r = 0;
        char[] chars = hexString.toCharArray();
        for (char c : chars) {
            int digit = charToNum(c);//字符转数字
            r = (r + digit) * 16;
        }
        return r / 16;
    }

    private static int charToNum(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c - 'A';
        }
    }
}

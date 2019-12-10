package com.snail.dynamicplanning;


/**
 * 题目：给定一个非负整数n，计算各个数字都不同的数字x的个数。
 * 其中 0 <= x <= 10的n次方
 * <p>
 * 解题思路：
 * 通过动态规划的思维来解决此问题。
 * 当n = 1时，满足条件的为 0-9，一共10个数。
 * 当n = 2时，由于第一个数是1-9中的一个了，所以可供选择的数为 0 - 9中的9个。
 * 同理，当 n = 3时，由于前面两个数各占了一个，可供选择的只有8个。
 * 以此类推就能得出结果。
 */
public class CountNumberWithUniqueDigits {

    public static int countNumberWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int result = 10;
        int sum = 9;
        for (int i = 2; i <= n; i++) {
            sum *= (10 - i + 1);
            result += sum;
        }
        return result;
    }

    public static void testInstance() {
        System.out.println("result = " + countNumberWithUniqueDigits(2));
    }
}

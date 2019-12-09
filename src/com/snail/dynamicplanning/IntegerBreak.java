package com.snail.dynamicplanning;


/**
 * 题目：给定一个整数n，将其拆分为至少两个正整数，并使这些整数的乘积最大化。
 * <p>
 * <p>
 * 解题思路：
 * 此问题可以采用动态规划的思路来处理。
 * 当n = 2时，可以分解成 1 + 1，乘积为 1 * 1
 * 当n = 3时，可以分解成 2 + 1，乘积为 2 * 1
 * 当n = 4时，可以分解成 1 + 3 和 2 + 2，可以看出，2 * 2 > 3 * 1
 * 由此可以得出规律，即将此整数分解成若干个3，当剩余的值为1时，需要将前一个分解成2*2，而不是3*1，这样才能得出最大的乘积。
 * 故而计算出最大的乘积。
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 3) {
            return 2;
        }
        int sum = 1;
        while (n >= 3) {
            sum *= 3;
            n -= 3;
            if (n == 2) {
                sum *= 2;
            }
            if (n == 1) {
                sum /= 3;
                sum *= 4;
            }
        }
        return sum;
    }

    public static void testInstance() {
        System.out.println("result = " + integerBreak(6));
    }
}

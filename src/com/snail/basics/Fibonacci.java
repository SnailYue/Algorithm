package com.snail.basics;

public class Fibonacci {

    /**
     * 题目：斐波那契数列问题,求第n项的值
     * <p>
     * 解题思路：使用递归会重复计算一些子问题，所以使用递归会导致时间复杂度升高。故需要降低时间复杂度
     * 考虑到第i项的值只与第i-1项和第i-2项有关。所以只需要存储前面的两项就能求解出第i项的值，
     * 将时间复杂度由O(n)降为O(1)
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n < 1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void testInstance() {
        System.out.println(fibonacci(10));
    }
}

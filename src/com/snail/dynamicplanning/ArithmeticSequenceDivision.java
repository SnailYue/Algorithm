package com.snail.dynamicplanning;

/**
 * 题目：如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 解题思路：由于是等差数列，所以需要满足的条件是a[i] - a[i - 1] == a[i - 1] - a[i - 2].
 * 但是如果在上一个条件成立的条件下，又满足a[i+1] - a[i] = a[i] - a[i-1],
 * 此时需要在前者的基础上再加1.故需要设置一个变量，用于记录上一次的记录的次数。
 * 如果当前的条件不成立，则将上一次的记录清零。
 */
public class ArithmeticSequenceDivision {

    public static int numberOfArithmeticSlices(int[] A) {
        if (null == A || A.length < 3) {
            return 0;
        }
        int res = 0;
        int cur = 0;
        int pre = 0;
        int size = A.length;
        for (int i = 2; i < size; i++) {
            if ((A[i - 1] - A[i - 2]) == (A[i] - A[i - 1])) {
                cur = pre + 1;
                pre = cur;
            } else {
                cur = 0;
                pre = 0;
            }
            res += cur;
        }
        return res;
    }

    public static void testInstance() {
        int[] A = new int[]{1, 2, 3, 4};
        System.out.println("result = " + numberOfArithmeticSlices(A));
    }
}

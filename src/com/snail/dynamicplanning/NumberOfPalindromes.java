package com.snail.dynamicplanning;


/**
 * 题目：给定一个字符串，计算字符串中回文数的个数
 * <p>
 * 解题思路：
 * 对于回文数的查找，由于回文数的特性，即正反的顺序都是一样的。
 * 由于在第i个字符的时候，我们需要一次比较 i-n 与 i+n是否相同。
 * 如果相同，则认为这个字符串是一个回文数。
 * 由于字符串的长度有可能是奇数，也有可能是偶数。所以需要分开计算。
 * 即i的情况和i，i+1的情况。
 */
public class NumberOfPalindromes {

    public static int countSunstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            /**
             * 当回文数是奇数时
             */
            res += helper(s.toCharArray(), i, i);
            /**
             * 当回文数是偶数时
             */
            res += helper(s.toCharArray(), i, i + 1);
        }
        return res;
    }

    public static int helper(char[] s, int i, int j) {
        int count = 0;
        /**
         * 用于判断是不是回文数
         */
        while (i >= 0 && j < s.length) {
            if (s[i] != s[j]) {
                break;
            }
            i--;
            j++;
            count++;
        }
        return count;
    }


    public static void testInstance() {
        String s = "abc";
        System.out.println("result = " + countSunstrings(s));
    }
}

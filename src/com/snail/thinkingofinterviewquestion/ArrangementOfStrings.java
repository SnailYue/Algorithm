package com.snail.thinkingofinterviewquestion;


/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 解题思路：
 * 求字符串的排列组合，可以看成两步：
 * 第一步求出所以可能出现在第一个位置的字符，即把第一个字符串和后面所有的字符串交换。
 * 第二步固定第一个字符，求出后面所有字符串的排列。
 */
public class ArrangementOfStrings {

    public static void permutation(String str) {
        /**
         * 判断输入的字符串是否合法
         */
        if (str.isEmpty() || str.length() == 0) {
            return;
        }
        permutation(str.toCharArray(), 0);
    }

    public static void permutation(char[] chars, int pos) {
        /**
         * 当pos == chars.length - 1时，所有的字符串均已交换完毕
         */
        if (pos == chars.length - 1) {
            System.out.println(chars);
            return;
        }
        for (int i = pos; i < chars.length; i++) {
            /**
             * 首部的字符串与其后面的字符串交换位置，包括自己。
             */
            char temp = chars[i];
            chars[i] = chars[pos];
            chars[pos] = temp;
            /**
             * 递归求后面的字符串的排列
             */
            permutation(chars, pos + 1);
            /**
             * 还原字符串的位置。
             */
            temp = chars[i];
            chars[i] = chars[pos];
            chars[pos] = temp;
        }
    }

    public static void testInstance() {
        permutation("abc");
    }
}

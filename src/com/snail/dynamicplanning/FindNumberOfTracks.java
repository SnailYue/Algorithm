package com.snail.dynamicplanning;

import java.util.Scanner;

/**
 * 题目：给定一个仅由小写字母组成的字符串。现在请找出一个位置，
 * 删掉那个字母之后，字符串变成回文。请放心总会有一个合法的解。
 * 如果给定的字符串已经是一个回文串，那么输出-1
 * <p>
 * 解题思路：
 * 首先判断输入的这个字符串是不是回文数。如果不是回文数，则开始使用for循环遍历这个字符串。
 * 逐个删除每位字符，判断删除后拼接的新的字符串是否是回文数。
 */
public class FindNumberOfTracks {

    public static void findNumberOfTracks() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int result;
        result = isNUmberOfTracks(str);
        if (-1 == result) {
            System.out.println("Remove postion is " + -1 + " , String = " + str);
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1, len);
            result = isNUmberOfTracks(newStr);
            if (result == -1) {
                System.out.println("Remove postion is " + i + " , String = " + newStr);
            }
        }
    }

    public static void testInstance() {
        findNumberOfTracks();
    }

    public static int isNUmberOfTracks(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                return i;
            }
            i++;
            j--;
        }
        return -1;
    }
}

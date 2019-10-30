package com.snail.highqualitycode;


/**
 * 题目：打印从1到最大的n位数
 * 解题思路：由于n可能非常大，所以要考虑大数问题，即不能使用int存储数据，需使用char数组存储。
 * 然后使用回溯法来打印所有的数
 */
public class PrintToMaxOfNDigits {
    public static void printToMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        printToMaxNDigits(number, 0);
    }

    public static void printToMaxNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number, "");
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            printToMaxNDigits(number, digit + 1);
        }
    }

    public static void printNumber(char[] number, String result) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            result += String.valueOf(number[index++]);
        }
        if (!result.isEmpty()) {
            if (Integer.valueOf(result) % 10 != 9) {
                System.out.print(result + " ");
            } else {
                System.out.println(result + " ");
            }
        }

    }

    public static void testInstance() {
        printToMaxNDigits(2);
    }
}

package com.snail.basics;

public class DuplicationInArray {
    /**
     * 题目要求：查找数组中任意重复的数
     * <p>
     * 解题思路：从头到尾扫描数组中的每个数字，首先判断这个数字时候等于i，如果是，则接着扫描下一个，
     * 反之，再与第m个数字进行比较，如果与第m个数字相等，则找到循环的数字。反之，与第m个数字进行交换彼此的值。
     * 直到发现重复的数字。
     *
     * @param data 输入的数组
     * @return 返回的重复的数
     */

    public static int getDumlication(int[] data) {

        if (data == null || data.length < 2) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            while (data[i] != i) {
                if (data[i] == data[data[i]]) {
                    return data[i];
                } else {
                    int temp = data[i];
                    data[i] = data[temp];
                    data[temp] = temp;
                }
            }
        }

        return -1;
    }
}

package com.snail.basics;

public class DuplicationInArray {
    /**
     * 题目要求：查找一维数组中任意重复的数
     * <p>
     * 解题思路：从头到尾扫描数组中的每个数字，首先判断这个数字时候等于i，如果是，则接着扫描下一个，
     * 反之，再与第m个数字进行比较，如果与第m个数字相等，则找到循环的数字。反之，与第m个数字进行交换彼此的值。
     * 直到发现重复的数字。
     * 此方法修改了数组中的数据
     *
     * @param data 输入的数组
     * @return 返回的重复的数
     */

    public static int getDumlication(int[] data) {

        if (data == null || data.length < 2) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            //判断数组是否越界
            while (data[i] != i && data[i] < data.length) {
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


    /**
     * 通过借助哈希表来实现，不改变数组原来的值，时间复杂度O(n),空间复杂度O(n)
     *
     * @param data 需要查找的数组
     * @return 返回的重复的数
     */
    public static int getDumlicationNotChangeArray(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }
        int[] hashTable = new int[data.length];
        for (int item : data) {
            if (item < data.length && hashTable[item] >= 1) {
                return item;
            } else if (item < data.length) {
                hashTable[item] = 1;
            }
        }
        return -1;
    }


    public static void test() {
        int[] testArray = new int[]{1, 3, 2, 6, 3, 5};
        System.out.println(getDumlication(testArray));
        System.out.println(getDumlicationNotChangeArray(testArray));
    }
}

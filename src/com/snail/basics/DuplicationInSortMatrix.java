package com.snail.basics;

public class DuplicationInSortMatrix {


    /**
     * 题目：二维数组，从左至右递增，从上至下递增，输入一个整数，判断数组中是否含有要查找的数
     * <p>
     * 解题思路：选取数组中右上角的数字，如果该数字等于要找的数，则结束查找。
     * 如果该数字大于要查找的数字，则剔除这个数字所在的列。
     * 如果该数字小于要查找的数字，则剔除这个数字所在的行。
     * 以此一步一步缩小查找的范围。
     *
     *
     * @param data
     * @param target
     * @return
     */
    public static boolean findInPartiallySortMatrix(int[][] data, int target) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return false;
        }
        int rowMax = data.length - 1;
        int colCur = data.length - 1;
        int rowCur = 0;
        while (true) {
            if (colCur < 0 || rowCur > rowMax) {
                return false;
            }
            if (data[rowCur][colCur] == target) {
                return true;
            }
            if (data[rowCur][colCur] < target) {
                rowCur++;
            } else {
                colCur--;
            }
        }
    }

    public static void testInstance() {
        int[][] data = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {4, 8, 11, 15}};
        System.out.println(findInPartiallySortMatrix(data, 15));
    }
}

package com.snail.thinkingofinterviewquestion;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixClockwisely {

    /**
     * 题目：顺时针打印矩阵
     * 解题思路：
     * 打印一圈分为四步:
     * 第一步从左至右打印。
     * 第二步从上至下打印。
     * 第三步从右至左打印。
     * 第四步从下至上打印。
     * <p>
     * 需要注意的问题：
     * 第一步总是需要的。第二步的终止的条件为起始行号小于结束行号
     * 第三步打印的条件为至少为两列。
     * 第四步打印的条件为必须要两行三列。
     *
     * @param matrix
     */
    public static void printMatrixClockwisely(int[][] matrix) {
        List<Integer> resut = new ArrayList<>();
        int row1 = 0, row2 = matrix.length - 1;
        int col1 = 0, col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2; i++) {
                resut.add(matrix[row1][i]);
            }
            for (int i = row1 + 1; i <= row2; i++) {
                resut.add(matrix[i][col2]);
            }
            if (row1 != row2) {
                for (int i = col2 - 1; i >= col1; i--) {
                    resut.add(matrix[row2][i]);
                }
            }
            if (col1 != col2) {
                for (int i = row2 - 1; i >= row1; i--) {
                    resut.add(matrix[i][col1]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        System.out.println("result = " + resut.toString());
    }
    
    public static void testInstance() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        printMatrixClockwisely(matrix);
    }
}

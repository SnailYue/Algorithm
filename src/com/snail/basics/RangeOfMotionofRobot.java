package com.snail.basics;


/**
 * 题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，他每次可以向上，下，左，右移动一格。
 * 但不能进入行坐标和列坐标的数位之和大于k的格子。例如，当K=18时，机器人能够进入方格（35，37），
 * 因为3+5+3+7 =18，但是它不能进入方格（35，38），
 * 因为3+5+3+8 = 19请问机器人能够到达多少个格子？
 * <p>
 * 解题思路：使用回溯法进行矩阵的遍历
 */
public class RangeOfMotionofRobot {

    /**
     * flag用于记录当前的点是否被访问过。
     *
     * @param number
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int number, int rows, int cols) {
        if (number <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] flag = new boolean[rows * cols];
        return movingCountCore(number, rows, cols, 0, 0, flag);
    }


    /**
     * 计算的核心算法  使用回溯法进行矩阵的遍历。
     *
     * @param number
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param flag
     * @return
     */
    public static int movingCountCore(int number, int rows, int cols, int row, int col, boolean[] flag) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return 0;
        }
        if (flag[row * cols + col] || !checkNumber(number, row, col)) {
            return 0;
        }
        flag[row * cols + col] = true;
        /**
         * 1用于表示当前的点的要求满足位数之和不大于K的要求
         * 同时使用递归的方式逐次遍历所有的点。
         */
        return 1 + movingCountCore(number, rows, cols, row - 1, col, flag)
                + movingCountCore(number, rows, cols, row + 1, col, flag)
                + movingCountCore(number, rows, cols, row, col - 1, flag)
                + movingCountCore(number, rows, cols, row, col + 1, flag);
    }

    /**
     * 用于检测当前所在的点是否越界
     *
     * @param number
     * @param row
     * @param col
     * @return
     */
    public static boolean checkNumber(int number, int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= number;
    }

    public static void testInstance() {
        System.out.println(movingCount(10, 20, 20));
    }
}

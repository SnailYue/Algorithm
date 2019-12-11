package com.snail.dynamicplanning;


/**
 * 题目：给定一个包含非负数的m*n的网格，请找出一条左上角到右下角的路径，
 * 使路径上的数字的总和文件最小。
 * <p>
 * 解题思路：
 * 由于题目要求是从左上角至右下角，所以从起点开始，有两条路径可以选择，向下和向右。
 * 故而先设置一个二维数组，由于存储dp[0][i]和dp[i][0]所经过的路径上的数字的和。
 * 然后根据这两条确定的路径中和最小的一个与dp[i][j]相加，确定当前选择路径的最小和。
 * 以此类推，就能计算出最小的路径。
 */
public class MinPathsSum {

    public static int minPathsSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = (dp[i][j - 1] > dp[i - 1][j] ? dp[i - 1][j] : dp[i][j - 1]) + grid[i][j];
                System.out.println("dp = " + dp[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void testInstance() {
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("result = " + minPathsSum(arr));
    }
}

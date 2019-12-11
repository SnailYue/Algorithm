package com.snail.dynamicplanning;


/**
 * 题目：一个机器人位于一个m*n的网格的左上角，机器人每次只能向下或向右移动一步，机器人视图达到网格的右下角。
 * 问共有多少条不同的路径？
 * <p>
 * 解题思路：
 * 由于机器人只能向下或向右移动一步。所以当机器人处于[0][i]或[i][0]，只有一种移动方案。
 * 当i，j的坐标大于0时，每个坐标点有可以形成两条路径，分别是左边的和上方的。
 * 故而可以求出机器人行走的全部路径。
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void testInstance() {
        System.out.println("result = " + uniquePaths(7, 3));
    }
}

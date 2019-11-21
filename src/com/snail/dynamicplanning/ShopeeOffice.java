package com.snail.dynamicplanning;

import java.math.BigInteger;
import java.util.Scanner;

public class ShopeeOffice {
    /**
     * 动态规划问题
     * 题目：shopee的办公室非常大，小虾同学的位置坐落在右上角，而大门却在左下角，
     * 可以把所有位置抽象为一个网格（门口的坐标为0，0），小虾同学很聪明，每次只向下，
     * 或者向左走，因为这样最容易接近目的地，但是小虾同学不想让自己的boss们看到自己经常在他们面前出没，
     * 或者迟到被发现。他决定研究一下如果他不通过boss们的位置，他可以有多少种走法？
     * <p>
     * 解题思路：
     * 因为只能向下或向左，所以到每一个坐标（x，y）的走法等于（x+1，y）的走法加上（x，y+1）的走法。
     * 原始坐标的那一排和那一列的坐标走法都是1，因为只能向左或向下，记得如果有boss的坐标是0，
     * 而且一旦遇到boss，那一排或那一列后面的坐标走法全部为0，因为遇上boss就过不去了
     */

    public static void shopeeOffice() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arrs = new int[x + 1][y + 1];
        long[][] dp = new long[x + 1][y + 1];
        for (int i = 0; i < n; i++) {
            int bossx = scanner.nextInt();
            int bossy = scanner.nextInt();
            arrs[bossx][bossy] = 1;
        }
        /**
         * 往左走
         */
        for (int i = x - 1; i >= 0; i--) {
            /**
             * 当前坐标没有boss时，才能赋值1；
             */
            if (arrs[i][y] == 0) {
                dp[i][y] = 1;
            }
            /**
             * 当坐标点有boss时，只能往左走。之前的点都被boss给挡住了.所以后面的所有的坐标点都要赋值0
             */
            else {
                for (int ii = i - 1; ii >= 0; ii--) {
                    dp[ii][y] = 0;
                }
            }
        }
        /**
         * 往下走走
         */
        for (int j = y - 1; j >= 0; j--) {
            /**
             * 当前的坐标点上没有boss时，才能赋值1
             */
            if (arrs[x][j] == 0) {
                dp[x][j] = 1;
            }
            /**
             * 当前的点有boss时，后面的点被挡住了，所以所有的点都赋值0。
             */
            else {
                for (int jj = j - 1; jj >= 0; jj--) {
                    dp[x][jj] = 0;
                }
            }
        }

        /**
         * 到每一个坐标dp[x][y]的走法等于dp[x + 1][y] + dp[x][y+1];
         */
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (arrs[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    /**
     * 测试用例函数
     */
    public static void testInstance() {
        shopeeOffice();
    }

}

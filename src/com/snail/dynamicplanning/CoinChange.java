package com.snail.dynamicplanning;


import java.util.Arrays;

/**
 * 题目：给定不同面额的硬币coins和一个总数amount，编写一个函数来计算可以凑成总金额所需的最小的硬币的个数。
 * 如果没有任何一种硬币的组合成总金额，则返回-1
 * <p>
 * 解题思路：
 * 我们采用自下而上的方式进行思考。在计算 F(i) 之前，我们先计算出 F(0)-F(i-1) 的答案。
 * F(i) 应等于minj=0…n−1F(i−cj) + 1，cj代表的是每个硬币的面值，所以
 * F(i)是前面能组成的金额的最小值 +1。
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void testInstance() {
        int[] coins = new int[]{1, 2, 5};
        System.out.println("result = " + coinChange(coins, 11));
    }
}

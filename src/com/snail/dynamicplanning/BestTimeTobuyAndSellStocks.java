package com.snail.dynamicplanning;

public class BestTimeTobuyAndSellStocks {

    /**
     * 题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
     * 设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 解题思路：
     * 使用动态规划的思维，要求出最大的利润，
     * 只需要求出后面的一天的价格减去前一天的价格得到最大的值即可。
     * 这样将一个大的问题分成若干个小的问题。
     *
     * @param prices
     * @return
     */
    public static int findMaxSumOfArrays(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = prices[i] >= min ? min : prices[i];
            max = max >= (prices[i] - min) ? max : (prices[i] - min);
        }
        return max;
    }

    public static void testInstance() {
        int[] arrays = new int[]{7, 1, 5, 3, 6 , 4};
        int result = findMaxSumOfArrays(arrays);
        System.out.println("result = " + result);
    }
}

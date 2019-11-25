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
     * @param arr
     * @return
     */
    public static int findMaxSumOfArrays(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return 0;
        }
        int minStart = arr[0];
        int maxEnd = arr[1];
        for (int i = 1; i < arr.length; i++) {
            int result = arr[i] - minStart;
            /**
             * 当相减的结果大于之前的最大的结果时，说明当前的利润更大，记录当前的值
             */
            if (result > (maxEnd - minStart)) {
                maxEnd = arr[i];
            }
            /**
             * 当相减的结果小于之前的最大结果时，再让其与当前最小的值相比较，如果小于当前的最小值。
             * 则将当前的值设为最小值。
             */
            else {
                if (minStart > arr[i]) {
                    minStart = arr[i];
                }
            }
        }
        return maxEnd - minStart;
    }

    public static void testInstance() {
        int[] arrays = new int[]{7, 2, 5, 1, 6, 4};
        int result = findMaxSumOfArrays(arrays);
        System.out.println("result = " + result);
    }
}

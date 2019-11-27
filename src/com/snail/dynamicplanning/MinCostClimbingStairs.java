package com.snail.dynamicplanning;

/**
 * 题目：数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 解题思路：
 * 使用动态规划的方案。如要找出花费最低的体力，由于一次只能走一步或两步，所以只需要记住索引为i的前两个索引 i - 1 和 i - 2；
 * 这样每次选择两个索引的最小值，就能找到花费最低体力的所有索引。
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        if (null == cost) {
            return -1;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return cost[0] > cost[1] ? cost[1] : cost[0];
        }
        int preResult = cost[0];
        int currentResult = cost[1];
        int result = 0;
        for (int i = 2; i < cost.length; i++) {
            result = cost[i] + (currentResult > preResult ? preResult : currentResult);
            preResult = currentResult;
            currentResult = result;
        }
        return result > preResult ? preResult : result;
    }

    public static void testInstance() {
        int[] arr = new int[]{1, 100, 1, 1, 1, 1, 100, 1};
        System.out.println("result = " + minCostClimbingStairs(arr));
    }
}

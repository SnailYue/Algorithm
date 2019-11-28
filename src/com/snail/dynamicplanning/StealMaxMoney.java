package com.snail.dynamicplanning;


/**
 * 题目：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 * <p>
 * 解题思路：
 * 由于小偷不能偷两个相连的房屋的金币，所以我们在第i个索引的时候，只需要考虑第 i - 2个索引与第 i - 1个索引的值，
 * 由于不能偷相连的房屋的金币，所以此时我们需要将 i + (i - 2)索引的值与i-1的索引的值进行比较，将大的加入到总的金币池。
 * 以此类推。计算出最终的金额即最大的金额。
 */
public class StealMaxMoney {

    public static int stealMaxMoney(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        if (2 == nums.length) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int preNums = nums[0];
        int currentNums = nums[0] > nums[1] ? nums[0] : nums[1];
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            result = (preNums + nums[i]) > currentNums ? (preNums + nums[i]) : currentNums;
            preNums = currentNums;
            currentNums = result;
        }
        return preNums > result ? preNums : result;
    }

    public static void testInstance() {
        int[] nums = new int[]{};
        System.out.println("result = " + stealMaxMoney(nums));
    }
}

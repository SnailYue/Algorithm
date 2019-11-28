package com.snail.dynamicplanning;

public class FindMaxSumOfArrays {

    /**
     * 动态规划问题
     * 题目：输入一个整型的数组，求数组中连续子数组的最大和。要求时间复杂度为O(n)
     * <p>
     * 解题思路：
     * 由于题目要求是连续的子数组，对于数组中的某个值arrs[i]，我们只需知道将其与arrs[i-1]的和进行比较，
     * 若相加的值大于arr[i-1]和中的值，则认为此值可以让数组中的和增大，以此重复计算。
     *
     * @param nums
     * @return
     */
    public static int findMaxSumOfArrays(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int currentSum = 0;
        int findMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            /**
             * 当currentSum的值小于0时，将计算和的连续索引往后移动。
             */
            if (currentSum <= 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > findMax) {
                findMax = currentSum;
            }
        }
        return findMax;
    }

    public static void testInstance() {
        int[] arrays = new int[]{8, 1, -2, 3, 10, -4, 7, 2, -5};
        int result = findMaxSumOfArrays(arrays);
        System.out.println("result = " + result);
    }
}

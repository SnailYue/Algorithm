package com.snail.dynamicplanning;


/**
 * 题目：给定一个正整数组nums，找出该数组内成绩小于k的连续子数组的个数
 * <p>
 * <p>
 * 解题思路：
 * 设置两个指针，fast与slow，乘积的区间为nums[slow]与nums[fast].
 * 当满足条件时：
 * 此时发现等fast等于slow时，其实只有一种子数组nums[fast]
 * 当fast与slow不相等时，fast与slow区间的全部子数组，必然包含所有的fast-1与slow区间的子数组。
 * 即fast与fast-1之间的区别仅在于是否包含nums[fast]元素。
 * 而包含全部的nums[fast]的子数组的元素等于fast-slow+1。
 * <p>
 * 当不满足条件时：
 * 乘积除以slow指针元素，slow前进。
 */
public class NumSubarrayProductLessThanK {

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int slow = 0;
            int mul = 1;
            int len = nums.length;
            for (int fast = 0; fast < len; fast++) {
                mul *= nums[fast];
                while (mul >= k && slow <= fast) {
                    mul /= nums[slow++];
                }
                result += fast - slow + 1;
            }
        }
        return result;
    }

    public static void testInstance() {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println("result = " + numSubArrayProductLessThanK(nums, 100));
    }
}

package com.snail.basics;

public class MinNumberInRotateArray {

    /**
     * 题目：把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     *
     * 解题思路：
     * 旋转之后的数组实际上可以划分成两个有序的子数组，
     * 前面的子数组的大小都大于后面子数组中的元素。
     *
     * 使用二分法查找最小的元素：
     * 1.使用两个指针left，right分别指向数组的第一个元素和最后一个元素。
     * 2.找到数组的中间元素：
     * 若中间元素大于第一个元素，则中间元素位于前面的递增子数组中。此时最小元素位于中间元素的后面。
     * 我们可以让第一个指针left指向中间元素。
     *
     * 中间元素小于第一个元素，则中间元素位于后面的递增子数组，此时最小元素位于中间元素的前面。
     * 我们可以让第二个指针right指向中间元素。移动之后，第二个指针仍然位于后面的递增数组中。
     *
     * 3.按照上面的思路，第一个指针left总是指向前面递增数组的元素，第二个指针right总是指向后面递增的数组元素。
     * 最终第一个指针指向前面数组的最后一个元素，第二个指针指向后面数组中的第一个元素。
     * 第二个指针指向的刚好是最小的元素。
     *
     * @param nums
     * @return
     */
    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            } else if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[h];
    }

    public static int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[l];
    }

    public static void testInstance() {
        int[] test = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(test));
    }
}

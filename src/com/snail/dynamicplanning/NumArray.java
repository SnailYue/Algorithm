package com.snail.dynamicplanning;


/**
 * 区域检索问题   数组不可变
 * <p>
 * 解题思路：
 * 由于题目提示数组不能发生变化，且会大量调用sumRange函数
 * 所以可以创建一个数组，由于存储i点所在的位置的前i项的和。
 * 这样在计算第i、j区间数组的和的大小的时候，只需前j项的和减去前i-1项的和即可。
 */
public class NumArray {
    int[] sumArray;
    int[] array;

    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            if (i == 0) {
                sumArray[i] = nums[i];
            } else {
                sumArray[i] = nums[i] + sumArray[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumArray[j] - sumArray[i] + array[i];
    }


    public static void testInstance() {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        System.out.println("result = " + numArray.sumRange(0, 5));
    }
}

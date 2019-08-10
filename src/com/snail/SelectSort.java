package com.snail;

/**
 * 选择排序
 * 1.从待排序序列中，找到关键字最小的元素；起始假定第一个元素为最小
 * 2.如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
 * 3.从余下的 N - 1 个元素中，找出关键字最小的元素，重复1，2步，直到排序结束。
 *
 * <p>
 * 时间复杂度与空间复杂度
 * 除了交换元素并未开辟额外的空间，所以额外的空间复杂度为O(1)。
 *
 * 对于时间复杂度而言，选择排序序冒泡排序一样都需要遍历 n(n-1)/2 次,但是相对于冒泡排序来说每次遍历只需要交换一次元素，
 * 这对于计算机执行来说有一定的优化。即使是有序数组，也需要进行 n(n-1)/2 次比较，
 * 所以其时间复杂度为O(n²)。
 *
 */

public class SelectSort {

    public static void setSelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // for 循环 i 之后所有的数字 找到剩余数组中最小值得索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 使用角标   交换元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

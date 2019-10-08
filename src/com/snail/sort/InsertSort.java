package com.snail.sort;

/**
 * 插入排序
 * <p>
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到下一位置中
 * 重复步骤2~5
 *
 * <p>
 * 时间复杂度与空间复杂度
 * <p>
 * 插入排序的算法时间平均复杂度为O(n²)。
 * 插入排序空间复杂度为 O(1)。
 * 插入排序为稳定排序。
 * 插入排序对于近乎有序的数组来说效率更高，插入排序可用来优化高级排序算法
 */
public class InsertSort {

    public static <T extends Comparable> void sort(T[] arr) {
        // 从位置1开始，与前面的比较
        for (int i = 1; i < arr.length; i++) {
            int j = i;  // j为最终需要插入的位置
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                j--;
            }
            // 如果需要插入到前面
            if (j < i) {
                // 插入到j位置
                T temp = arr[i];
                System.arraycopy(arr, j, arr, j + 1, i - j);
                arr[j] = temp;
            }
        }
    }
}

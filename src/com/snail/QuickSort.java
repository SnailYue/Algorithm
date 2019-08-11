package com.snail;


/**
 * 双路快速排序
 * <p>
 * 1.跟单路一样，双路快速排序，同样选择数组的第一个元素当做标志位（经过随机选择后的）
 * 2.双路快速排序要求有两个指针，指针 i j 分别指向 l+1 和 r 的位置然后两者同时向数组中间遍历
 * 在遍历过程中要保证arr[l+1 ... i) <= v， arr(j....r] >= v 因此我们可以初始化 i = l+1
 * 以保证左侧区间初始为空，j = r 保证右侧空间为空
 * 3.遍历过程中要 i <= r 且 arr[i] <= v 的时候 i ++ 就可以了 当 arr[i] > v 时表示遇到了 i 的值大于 v 数值
 * 此刻能等待 j 角标的值，从右向左遍历数组 当 arr[i] < v 表示遇到了 j 的值小于 v 的元素，它不该在这个位置呆着，
 * 4.得到了 i j 的角标后 先要判断是否到了循环结束的时候了，即 i 是否已经 大于 j 了。
 * 5.否则 应该讲 i 位置的元素和 j 位置的元素交换位置，然后 i++ j-- 继续循环
 * 6/遍历结束的条件是 i>j 此时 arr[j]为最后一个小于 v 的元素 arr[i] 为第一个大于 v 的元素
 * 因此 j 这个位置 就应该是 v 所应该在数组中的位置 因此遍历结束后需要交换 arr[l] 与 arr[j]
 *
 * <p>
 * 时间复杂度与空间复杂度
 * 算法时间复杂度最优为 O(nlogn)。当然最坏情况就是之前我们分析的有序数组，那么每次都需要进行 n 次比较则
 * 时间复杂度为 O(n²)，但是在平均情况 时间复杂度为 O(nlogn)
 * <p>
 * 平均的空间复杂度也是 O(nlogn)
 */
public class QuickSort {

    public static void setQuickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int p = partition(arr, l, r);
        setQuickSort(arr, l, p - 1);
        setQuickSort(arr, p + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int randomNum = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomNum);

        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] <= v)
                i++;
            while (j >= l + 1 && arr[j] >= v)
                j--;
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j++;

        }
        swap(arr, l, j);
        return j;
    }

    /**
     * 交换两个位置之前的值
     *
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

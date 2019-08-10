package com.snail;

/**
 * 归并排序
 * <p>
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4.重复步骤3直到某一指针到达序列尾
 * 5.将另一序列剩下的所有元素直接复制到合并序列尾
 * <p>
 * <p>
 * 时间复杂度与空间复杂度
 * 归并排序的算法时间平均复杂度为O(nlog(n))。
 * 归并排序空间复杂度为 O(n)。
 * 归并排序为稳定排序。
 */


public class MergeSort {
    /**
     * @param arr 待排序数组
     * @param l   其实元素角标 0
     * @param r   最后一个元素角标 n -1
     */
    public static void setMergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //开始归并排序 向下取整
        int mid = (l + r) / 2;

        //递归划分数组
        setMergeSort(arr, l, mid);
        setMergeSort(arr, mid + 1, r);

        //检查是否上一步归并完的数组是否有序，如果有序则直接进行下一次归并
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        //将两边的元素归并排序
        merge(arr, l, mid, r);
    }

    /**
     * arr[l,mid] 和  arr[mid+1,r] 两部分进行归并
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        // 复制等待归并数组 用来进行比较操作，最将原来的 arr 每个角标赋值为正确的元素
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //说明左边部分已经全都放进数组了
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //说明左边部分已经全都放进数组了
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                //当左半个数组的元素值小于右边数组元素值得时候 赋值为左边的元素值
                arr[k] = aux[i - l];
                i++;
            } else {
                //当左半个数组的元素值大于等于右边数组元素值得时候 赋值为左边的元素值 这样也保证了排序的稳定性
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}

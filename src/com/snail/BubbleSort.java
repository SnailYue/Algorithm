package com.snail;


/**
 * 冒泡排序
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p>
 * 时间复杂度及空间复杂度
 * 对于长度为 n 的数组，冒泡排序需要经过 n(n-1)/2 次比较，最坏的情况下，即数组本身是倒序的情况下，需要经过 n(n-1)/2 次交换
 * 即：冒泡排序的算法时间平均复杂度为O(n²)。空间复杂度为 O(1)。
 */
public class BubbleSort {

    public static void setBubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}

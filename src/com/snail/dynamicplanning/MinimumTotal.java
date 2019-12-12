package com.snail.dynamicplanning;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个三角形，找出自顶向下的最小路径和。每步智能移动到下一行中相邻的节点上。
 * <p>
 * 解题思路：
 * 设定一个一维数组，从下至上的方式记录当前行与下一行之间的所组成路径的最小和。
 * 以此的形式，自下而上遍历，至dp[0]是，就是当前路径的最小和。
 */

public class MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        /**
         * 先遍历最后一行所有节点的值放置在数组dp中。
         */
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        /**
         * 至下而上遍历，由于最后一行已经遍历完成放置在dp中，所有直接从倒数第二行开始遍历。
         */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                /**
                 * 比较两个相邻的结点指点的大小，取小的值，同时由于上一行中的结点可以在下一行中产生两条路径。
                 * 所以下一行中的小的值与上一行中的结点相加，产生新的路径和。
                 * 以此形式进行遍历，最终dp[0]的值就是最小的路径和
                 */
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void testInstance() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println("result = " + minimumTotal(lists));
    }
}

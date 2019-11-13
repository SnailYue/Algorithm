package com.snail.thinkingofinterviewquestion;

import java.util.*;

public class PositiveAndReversePrintBinaryTree {

    /**
     * 题目：之字型从上至下打印二叉树
     * 解题思路：
     * 创建一个队列,用于队列的先进先出的特性，对每一个节点进行入队列，同时把其叶子也如队列。
     * 由于先进先出的特性，就能实现对每层的遍历。
     * 同时创建一个数列，用于存储取出的结点。这样就实现了对二叉树从上至下的遍历。
     * 设置一个布尔值用于记录当前遍历的行是正序还是逆序，当为false时，为正序，为false时，是逆序。
     *
     * @param root
     * @return
     */

    public static List<List<Integer>> printBinaryTree(BinaryTreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        boolean isReverse = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> list = new ArrayList<>();
            while (cnt-- > 0) {
                BinaryTreeNode<Integer> t = queue.poll();
                if (null == t) {
                    continue;
                }
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if (isReverse) {
                Collections.reverse(list);
            }
            isReverse = !isReverse;
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    public static void testInstance() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        List<List<Integer>> result = printBinaryTree(root);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static class BinaryTreeNode<T> {
        private T val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}

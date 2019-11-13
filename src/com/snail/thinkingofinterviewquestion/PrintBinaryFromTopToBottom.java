package com.snail.thinkingofinterviewquestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryFromTopToBottom {
    /**
     * 题目：从上至下打印出二叉树的每个节点，同一层的节点按照从左至右的顺序打印。
     * 解题思路：
     * 创建一个队列,用于队列的先进先出的特性，对每一个节点进行入队列，同时把其叶子也如队列。
     * 由于先进先出的特性，就能实现对每层的遍历。
     * 同时创建一个数列，用于存储取出的结点。这样就实现了对二叉树从上至下的遍历。
     *
     * @param root
     * @return
     */

    public static List<Integer> printBinaryTree(BinaryTreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                BinaryTreeNode<Integer> t = queue.poll();
                if (null == t) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
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
        List<Integer> result = printBinaryTree(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
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

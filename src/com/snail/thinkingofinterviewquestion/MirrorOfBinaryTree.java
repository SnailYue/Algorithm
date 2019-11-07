package com.snail.thinkingofinterviewquestion;

public class MirrorOfBinaryTree {

    /**
     * 题目：输入一个二叉树，输出这个二叉树的镜像
     * 解题思路：
     * 从上至下依次遍历所有的叶子结点，并交换两个叶子结点的位置
     *
     * @param tree
     * @return
     */
    public static BinaryTree mirror(BinaryTree tree) {
        if (null == tree) {
            return null;
        }
        if (null == tree.left && null == tree.right) {
            return tree;
        }
        /**
         * 交换两个叶子结点的位置
         */
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        if (null != tree.left) {
            /**
             * 递归遍历左子树
             */
            mirror(tree.left);
        }
        if (null != tree.right) {
            /**
             * 递归遍历右子树
             */
            mirror(tree.right);
        }
        return tree;
    }

    public static void testInstance() {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        printResult(mirror(tree));
    }

    /**
     * 前序输出二叉树
     * @param result
     */
    public static void printResult(BinaryTree result) {
        if (null != result) {
            System.out.println("result = " + result.val);
            printResult(result.left);
            printResult(result.right);
        }
    }

    static class BinaryTree<T> {
        public T val;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(T val) {
            this.val = val;
        }
    }
}

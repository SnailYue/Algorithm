package com.snail.thinkingofinterviewquestion;


/**
 * 题目：输入一个二叉搜索树，将该二叉树转换成一个排列的双向链表。
 *
 * 解题思路：
 * 按照中序遍历的顺序，当我们遍历转换到根节点时，它的左子树已经转换成一个排序的链表了。
 * 并且处在链表中的最后一个节点中的最后一个节点。接着遍历转换成右子树，
 * 并把根节点和右子树中最小的结点链接起来。
 */

public class BinaryTreeWithDoublyLinkedList {
    private static BinaryTree pre = null;
    private static BinaryTree head = null;

    public static BinaryTree Convert(BinaryTree root) {
        inOrder(root);
        return head;
    }

    public static void inOrder(BinaryTree node) {
        if (null == node) {
            return;
        }
        /**
         * 先遍历至左叶子节点
         */
        inOrder(node.left);
        /**
         * 使用左子树指向上一个节点。
         */
        node.left = pre;
        if (null != pre) {
            pre.right = node;
        }
        /**
         * 将上一个节点赋值为当前节点。
         */
        pre = node;
        if (null == head) {
            head = node;
        }
        /**
         * 遍历右节点
         */
        inOrder(node.right);
    }

    public static void testInstance() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        root.left = new BinaryTree<>(6);
        root.right = new BinaryTree<>(14);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(8);
        root.right.left = new BinaryTree(12);
        root.right.right = new BinaryTree(16);
        BinaryTree result = Convert(root);
        while (null != result) {
            System.out.println(result.val);
            result = result.right;
        }
    }

    static class BinaryTree<T> {
        private T val;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(T val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
}

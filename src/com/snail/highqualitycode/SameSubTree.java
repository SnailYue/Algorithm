package com.snail.highqualitycode;

public class SameSubTree {

    /**
     * 题目：输入两个二叉树A和B，判断B是不是在A的子结构。
     * 解题思路：
     * 1.先确定A的哪些结点与B的根节点的值相同。
     * 2.找到相同的结点之后，再与B树的子结点进行比较。
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        if (isSubTreeWithRoot(root1, root2)) {
            return true;
        } else {
            /**
             * 遍历A树的左子树与右子树
             */
            return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
        }
    }

    /**
     * 判断叶子结点是否相同
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSubTreeWithRoot(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == root1) {
            return false;
        }
        /**
         * 根结点相同后比较叶子结点是否相同
         */
        if (root1.val == root2.val) {
            return isSubTreeWithRoot(root1.left, root2.left) && isSubTreeWithRoot(root1.right, root2.right);
        } else {
            return false;
        }
    }


    public static void testInstance() {
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
        root1.left = new BinaryTreeNode(2);
        root1.right = new BinaryTreeNode(3);
        root1.left.left = new BinaryTreeNode(4);
        root1.left.right = new BinaryTreeNode(5);

        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(2);
        root2.left = new BinaryTreeNode(4);
        root2.right = new BinaryTreeNode(5);
        System.out.println("result = " + hasSubTree(root1, root2));

    }

    static class BinaryTreeNode<T> {
        public T val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(T val) {
            this.val = val;
        }
    }
}

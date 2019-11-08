package com.snail.thinkingofinterviewquestion;

public class SymmetryBinaryTree {


    /**
     * 题目：输入一个二叉树，判断这个二叉树是不是对称的。
     * <p>
     * 解题思路：在二叉树的遍历过程中，都是先遍历左节点，然后再遍历有节点。
     * 此时我们可以定义一种遍历二叉树的方法，先遍历右节点，再遍历左节点。
     * 然后再与先遍历左节点再遍历有节点的方法进行逐个节点的比较。若全部相同，即就是对称二叉树。
     *
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(BinaryTree pRoot) {
        if (null == pRoot) {
            return true;
        }
        return isSymmetrical(pRoot, pRoot);
    }

    public static boolean isSymmetrical(BinaryTree root1, BinaryTree root2) {
        if (null == root1 && null == root2) {
            return true;
        }
        if (null == root1 || null == root2) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    public static void testInstance() {
        BinaryTree<Integer> root = new BinaryTree<>(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(3);
        root.left.right = new BinaryTree(4);
        root.right.left = new BinaryTree(4);
        root.right.right = new BinaryTree(3);

        System.out.println("resu;t = " + isSymmetrical(root));
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

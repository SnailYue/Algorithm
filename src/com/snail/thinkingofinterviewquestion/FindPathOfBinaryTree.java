package com.snail.thinkingofinterviewquestion;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：输入一个二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * <p>
 * 解题思路：
 * 当用前序遍历的方式访问到某一个节点时，我们应该把此节点添加都路径上，并累加该节点的值。
 * 如果该节点为叶子结点，并且路径中节点的值的和刚好为输入的整数。则符合当前路径的要求。
 * 如果当前结点不是叶子结点，则继续访问它的子节点，当前的结点访问结束后，递归会自动回到他的父节点。
 * 因此，我们在函数退出之前要在路径上删除当前结点并减去当前结点保存的值。
 */
public class FindPathOfBinaryTree {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> findPathOfBinaryTree(BinaryTree root, int sum) {
        if (root == null) {
            return null;
        }
        findPathCore(root, sum, new ArrayList<>());
        return lists;
    }

    public static void findPathCore(BinaryTree<Integer> root, int targe, List<Integer> path) {
        if (null == root) {
            return;
        }
        /**
         * 先把节点添加都路径中，当不满足条件时，可以移除此节点。
         */
        path.add(root.val);
        targe -= root.val;
        if (0 == targe && null == root.left && null == root.right) {
            /**
             * 满足路径的条件，加入到路径列表中。
             */
            lists.add(new ArrayList<>(path));
        } else {
            findPathCore(root.left, targe, path);
            findPathCore(root.right, targe, path);
        }
        /**
         * 当不满足条件时，移除添加的节点。
         */
        path.remove(path.size() - 1);
    }

    public static void testInstance() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        root.left = new BinaryTree(5);
        root.right = new BinaryTree(12);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(7);
        List<List<Integer>> result = findPathOfBinaryTree(root, 22);
        for (int i = 0; i < result.size(); i++) {
            int size = result.get(i).size();
            for (int j = 0; j < size; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static class BinaryTree<T> {
        private T val;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}

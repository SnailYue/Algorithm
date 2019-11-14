package com.snail.thinkingofinterviewquestion;

public class VerifySquenceOfBST {

    /**
     * 题目：输入一个整数数组，判断该数组是不是某个二叉搜索树的后续遍历结果。
     * 解题思路：
     * 在后序遍历的序列中，最后一个数字是树的根节点。
     * 而数组中前面的数字可以分为两个部分：第一部分时左子树的节点的值，其值都比根节点的值小。
     * 第二部分为右子树的节点的值，其值都比根节点的值大。
     *
     * @param squence
     * @param length
     * @return
     */

    public static boolean verifySquenceOfBST(int[] squence, int length) {
        if (null == squence || length <= 0) {
            return false;
        }
        int root = squence[length - 1];

        /**
         * 在二叉搜索树中左子树节点的值小于根节点的值
         */
        int i = 0;
        for (; i < length - 1; ++i) {
            if (squence[i] > root) {
                break;
            }
        }
        /**
         * 在二叉搜索树中右子树节点的值大于根节点的值
         */
        int j = i;
        for (; j < length - 1; j++) {
            if (squence[j] < root) {
                break;
            }
        }
        /**
         * 判断左子树是不是二叉树的搜索树
         */
        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(squence, i);
        }
        /**
         * 判断右子树是不是二叉树的搜索树
         */
        boolean right = true;
        if (i < length - 1) {
            right = verifySquenceOfBST(squence, length - i - 1);
        }
        return (left && right);

    }

    public static void testInstance() {
        boolean result = verifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}, 7);
        System.out.println("result = " + result);
    }
}

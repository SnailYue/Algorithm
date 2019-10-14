package com.snail.basics;


public class ReConstructBinaryTree {


    /**
     * 前序遍历及中序遍历然后重构二叉树
     *
     * 思路讲解：前序的第一个数是根节点，根据此节点，在中序的数组中查找相同的节点。
     * 在中序数组中确定根节点之后，其左边的为根节点的左树，右边的为根节点的右树。以此递归，进行重构。
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || preOrder.length != inOrder.length) {
            return null;
        }
        return reConstructCore(preOrder, 0, inOrder, 0, preOrder.length);
    }

    public static TreeNode reConstructCore(int[] preOrder, int preOrderStart, int[] inOrder, int inOrderStart, int length) {
        if (length == 0) {
            return null;
        }
        int inOrderIndex = -1;
        for (int i = inOrderStart; i < inOrderStart + length; i++) {
            if (inOrder[i] == preOrder[preOrderStart]) {
                inOrderIndex = i;
                break;
            }
        }
        int leftLength = inOrderIndex - inOrderStart;
        TreeNode node = new TreeNode(preOrder[preOrderStart]);
        node.left = reConstructCore(preOrder, preOrderStart + 1, inOrder, inOrderStart, leftLength);
        node.right = reConstructCore(preOrder, preOrderStart + leftLength + 1, inOrder, inOrderIndex + 1, length - leftLength - 1);
        return node;
    }

    public static void testInstance() {
        int[] preOrder = {1,2,4,5,3};
        int[] inOrder = {4,2,5,1,3};
        TreeNode node = reConstructBinaryTree(preOrder,inOrder);
        System.out.println("构建二叉树前序遍历：" + TraversalOfBinaryTree.preOrderRecursively(node));
        System.out.println("构建二叉树中序遍历：" + TraversalOfBinaryTree.inOrderRecursively(node));
        System.out.println("构建二叉树后续遍历：" + TraversalOfBinaryTree.postOrderRecursively(node));
    }
}

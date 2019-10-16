package com.snail.basics;

public class NextNodeInBinaryTree {

    /**
     * 以中序遍历的方式，查找二叉树的下一个节点。
     * 解题思路：1.如果该节点有右子树，则该节点的下一个节点为该节点的右子树的最左节点
     * 2.如果该节点没有右子树，又分两种情况：
     * 1).如果该节点为父节点的左节点，则该节点的父节点则为下一个节点。
     * 2).如果该节点为父节点的右节点，则该节点的父节点的父节点，直到其中的一个父节点时这个父节点的左节点，
     * 才为该节点的父节点的下一个节点。
     *
     * @param pNode
     * @return
     */
    public static TreeNode getNext(TreeNode pNode) {
        if (pNode == null) {
            return null;
        } else if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.father != null) {
            if (pNode.father.left == pNode) {
                return pNode.father;
            }
            pNode = pNode.father;
        }
        return null;
    }

    public static void testInstance() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father = root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;
        System.out.println(getNext(root.left.left).val);
        System.out.println(getNext(root.left).val);
        System.out.println(getNext(root.left.right).val);
        System.out.println(getNext(root).val);
        System.out.println(getNext(root.right));
    }
}

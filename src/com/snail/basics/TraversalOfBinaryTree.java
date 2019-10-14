package com.snail.basics;

import java.util.ArrayList;
import java.util.List;

public class TraversalOfBinaryTree {

    /**
     * 二叉树的前序遍历
     *
     * @param node
     * @return
     */
    public static List<Integer> preOrderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.add(node.val);
        list.addAll(preOrderRecursively(node.left));
        list.addAll(preOrderRecursively(node.right));
        return list;
    }

    /**
     * 二叉树的中序遍历
     *
     * @param node
     * @return
     */
    public static List<Integer> inOrderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(inOrderRecursively(node.left));
        list.add(node.val);
        list.addAll(inOrderRecursively(node.right));
        return list;
    }

    /**
     * 二叉树的后序遍历
     *
     * @param node
     * @return
     */
    public static List<Integer> postOrderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(postOrderRecursively(node.left));
        list.addAll(postOrderRecursively(node.right));
        list.add(node.val);
        return list;
    }
}

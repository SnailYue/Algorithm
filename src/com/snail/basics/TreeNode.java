package com.snail.basics;

public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> father;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.father = null;
    }
}

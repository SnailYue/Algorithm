package com.snail.thinkingofinterviewquestion;


/**
 * 题目：请实现两个函数，分辨用来序列化和反序列化
 * <p>
 * 解题思路：
 * 序列化：将二叉树通过前序的方式转换成字符串，当节点为null时，使用$代替。
 * 反序列化：由于序列化的方式使用的是前序前序遍历的方式，所以把序列化的字符串转化成二叉树时，
 * 可以逐个取出字符串中的每个节点，然后按照前序遍历的特性重构二叉树。
 */
public class SerializeAndDeserializeOfBinaryTree {

    private static String deserialize;

    /**
     * 二叉树的序列化
     *
     * @param root
     * @return
     */
    public static String serialize(BinaryTree root) {
        if (null == root) {
            return "$";
        }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    /**
     * 二叉树的反序列化
     *
     * @param str
     * @return
     */
    public static BinaryTree deserializeBinaryTree(String str) {
        deserialize = str;
        return deserialize();
    }

    private static BinaryTree deserialize() {
        if (null == deserialize || deserialize.length() == 0) {
            return null;
        }
        /**
         * 获取第一个分割符的位置
         */
        int index = deserialize.indexOf(" ");
        /**
         * 截取第一个字符串
         */
        String node = index == -1 ? deserialize : deserialize.substring(0, index);
        /**
         * 移除被截取的字符串
         */
        deserialize = index == -1 ? "" : deserialize.substring(index + 1);
        /**
         * 当当前的字符为$时，表示当前的节点为空。
         */
        if (node.equals("$")) {
            return null;
        }
        /**
         * 将字符串转化成数字。
         */
        int val = Integer.valueOf(node);
        /**
         * 创建新结点
         */
        BinaryTree t = new BinaryTree(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }

    public static void testInstance() {
        BinaryTree<Integer> root = new BinaryTree<>(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        String serializeResult = serialize(root);
        System.out.println("serializeResult = " + serializeResult);
        BinaryTree deserializeResult = deserializeBinaryTree(serializeResult);
        printBinaryTree(deserializeResult);
    }

    /**
     * 前序遍历输出二叉树
     *
     * @param root
     */
    public static void printBinaryTree(BinaryTree root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
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

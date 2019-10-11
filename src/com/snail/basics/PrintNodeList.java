package com.snail.basics;

import java.util.Stack;

public class PrintNodeList {

    static class ListNode<T> {
        public T val;
        public ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
            this.next = null;
        }

    }

    /**
     * 使用递归实现，使用递归，先找出其后面的节点，再输出其自身。
     *
     * @param node
     */
    public static void printNodeList(ListNode<Integer> node) {
        if (node == null) {
            return;
        } else {
            printNodeList(node.next);
            System.out.println(node.val);
        }
    }

    /**
     * 使用栈的先进后出特性实现，先入栈，后出栈
     *
     * @param nodes
     */
    public static void printNodeListOfStack(ListNode<Integer> nodes) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode<Integer> temp = nodes; temp != null; temp = temp.next) {
            stack.add(temp.val);
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void testInstance() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        printNodeList(head);
        printNodeListOfStack(head);
    }
}

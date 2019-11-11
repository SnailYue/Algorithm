package com.snail.thinkingofinterviewquestion;


import java.util.Stack;


/**
 * 题目：定义栈的数据结构，在该类型中实现一个能够得到栈的最小元素的 min函数。
 * 在该栈中，调用min，push，pop的事件复杂度都是O(1)。
 *
 * 解题思路：
 * 定义一个辅助的栈，把排序后的元素压入辅助栈中。每次取出最小的值的时候，就把辅助栈中获取。
 * 这样就可以实现每次都能都获取到最小的元素。
 *
 */
public class MinElementOfStack {

    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈
     * @param val
     */
    public static void push(Integer val) {
        dataStack.push(val);
        minStack.push(minStack.isEmpty() ? val : Math.min(minStack.peek(), val));
    }

    public static void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public static int min() {
        return minStack.peek();
    }

    public static int top() {
        return dataStack.peek();
    }

    public static void testInstance() {
        push(3);
        push(4);
        push(2);
        push(1);
        push(5);

        /**
         * stack top element
         */
        System.out.println("top element : " + top());
        /**
         * min element
         */
        System.out.println("min element : " + min());
    }
}

package com.snail.basics;

import java.util.Stack;

public class QueueWithTwoStacks{

    /**
     * 题目：使用两个栈实现一个队列
     * 解题思路：新增一个元素，直接添加至stack1中。
     * 删除一个元素，当stacks2不为空时，在stacks2中的栈顶元素是最先进入队列的元素，可以弹出。
     * 当stacks2为空时，吧stacks1中的员超速逐个弹出并压入stacks2中。由于新进入队列的元素被压到了stacks1
     * 的低端，进过弹出和压入到stacks2中以后就位于stacks2的顶端，可以弹出。
     *
     * 由于栈的特点是先进后出，经过两次入栈之后，就会变成先进先出，达到队列的效果。
     * @param <T>
     */
    static class Queue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void offer(T data) {
            stack1.push(data);
        }

        public T poll() {
            /**
             * 当stacks2不为空，直接弹出
             */
            if (!stack2.empty()) {
                return stack2.pop();
            }
            /**
             * 当stacks2为空，stacks1不为空，
             * 先将stacks1中的弹出放入到stacks2中，
             * 然后从stacks2中取出。
             */
            else if (!stack1.empty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
            else {
                return null;
            }
        }
    }

    public static void twoStacksWithQueue(){
        Queue<Integer> queue = new Queue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
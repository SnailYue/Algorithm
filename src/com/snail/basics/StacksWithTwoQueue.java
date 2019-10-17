package com.snail.basics;

import java.util.LinkedList;
import java.util.Queue;

public class StacksWithTwoQueue {

    /**
     * 题目：使用两个队列实现栈的功能，及先进后出
     * 解题思路：
     * 对于插入操作，栈和队列都是从队尾进行的，所以很容易完成。
     * 对于弹出操作：队列从头开始，而栈从队尾开始。要想获取队尾的元素，需要第二个队列的协助
     * 假设queue1不为空，queue2为空，将queue1的元素依次取出放到queue2中，同时判断queue1的长度为1时，
     * 不将该元素放入到queue2中，而是直接取出丢弃，此时完成了栈的取出操作。
     * 也就是说，弹出一个元素，其他的元素的存储位置将会从本队列移动至另外一个队列。即两个队列中，其中一个必为空。
     * @param <T>
     */
    static class MyStacks<T> {
        private Queue<T> queue1 = new LinkedList<>();
        private Queue<T> queue2 = new LinkedList<>();

        public void push(T data) {
            if (!queue2.isEmpty()) {
                queue2.offer(data);
            } else {
                queue1.offer(data);
            }
        }

        public T pop() {
            if (!queue2.isEmpty()) {
                int size = queue2.size();
                for (int i = 0; i < size - 1; i++) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            } else if (!queue1.isEmpty()) {
                int size = queue1.size();
                for (int i = 0; i < size - 1; i++) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            } else {
                return null;
            }
        }
    }

    public static void stacksWithTwoQueue() {
        MyStacks<Integer> stacks = new MyStacks<>();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        stacks.push(4);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }

    public static void testInstance() {
        stacksWithTwoQueue();
    }
}

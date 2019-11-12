package com.snail.thinkingofinterviewquestion;

import java.util.Stack;

public class PushAndPopOfStack {


    /**
     * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列为序列的弹出顺序。
     * 解题思路：
     * 设置一个辅助的栈，把第一个序列逐次入栈，在入栈的同时判断位于栈顶的元素是否为出栈序列中的最先出栈数，
     * 如果相同的话，把位于辅助栈栈顶的元素出栈，然后在把第一个序列中剩余的元素再入栈。
     * 以此遍历入栈。直至第一个序列中的元素全部入栈。
     *
     * @param push
     * @param pop
     * @return
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (null == push && null == pop) {
            return true;
        }
        if (push.length != pop.length) {
            return false;
        }
        int n = push.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(push[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void testInstance() {
        System.out.println("result = " + isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

}

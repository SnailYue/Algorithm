package com.snail.highqualitycode;

public class DeleteDumplicationNodeOfListNode {

    /**
     * 题目：删除链表中重复的结点
     * 解题思路：使用递归来遍历当前的结点与下一个结点是否相同。
     * 如果相同，则将下一个结点指向其下一个结点
     * @param pHead
     * @return
     */
    public static ListNode deleteDumplicationNodeOfListNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDumplicationNodeOfListNode(next);
        } else {
            pHead.next = deleteDumplicationNodeOfListNode(pHead.next);
            return pHead;
        }
    }

    public static void testInstance() {
        ListNode<Integer> node = new ListNode<>(1);
        node.next = new ListNode<>(2);
        node.next.next = new ListNode<>(3);
        node.next.next.next = new ListNode<>(2);
        ListNode result = deleteDumplicationNodeOfListNode(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class ListNode<T> {
        public T val;
        public ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
            this.next = null;
        }
    }
}

package com.snail.highqualitycode;

public class MergeListNode {

    /**
     * 题目：合并两个链表
     * 解题思路：使用递归将链表中的当前结点进行比较，
     * 若第一个链表当前结点的值小于第二链表的当前结点的值，
     * 则将第一个结点向后移动一位，在于第二个结点进行比较。以此递归。
     * 直至其中一个链表没有结点为止。
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeLisNode(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = mergeLisNode(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLisNode(head1, head2.next);
            return head2;
        }
    }

    public static void testInstance() {
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        ListNode result = mergeLisNode(head1, head2);
        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class ListNode<T> {
        public T val;
        public ListNode next;

        public ListNode(T val) {
            this.val = val;
            this.next = null;
        }
    }
}

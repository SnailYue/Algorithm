package com.snail.highqualitycode;

public class FindKthToTail {

    /**
     * 题目：链表中的倒数第k个结点
     * 解题思路：
     * 由于不知道链表的长度，所以设置两个指针p1，p2，先让p1移动到第k个结点，这还剩N - k个结点，
     * 此时p1与p2同时移动，当p1移动到链表的结尾时，p2移动到N-k个结点。则该点为倒数第k个结点。
     *
     * @param head
     * @param k
     * @return
     */

    public static ListNode findKthToTail(ListNode head, int k) {
        if (null == head || k < 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = null;
        for (int i = 0; i < k - 1; ++i) {
            if (null != p1.next) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        p2 = head;
        while (null != p1.next) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    public static void testInstance() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        System.out.println("result = " + findKthToTail(head, 3).val);
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

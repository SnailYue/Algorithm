package com.snail.highqualitycode;

public class ReverseListNode {

    /**
     * 题目：链表的反转
     * 解题思路：
     * 设置3个指针，分别指向当前遍历到的结点(head)、它的上一个结点(pre)及后一个结点(next)。
     * 1.将当前的链表往后遍历，每遍历一个结点，把当前的结点移除(步骤1)。
     * 2.把这个节点的下一个结点指向上一个结点。这样就交换了两个结点的位置。
     * 3.把交换位置后的链表放到上一个链表中。
     * 4.新的链表以原始链表的下一个结点开始。
     * 以此循环，达到链表反转的目的
     *
     * @param pHead
     * @return
     */

    public static ListNode reverseListNode(ListNode pHead) {

        if (null == pHead || null == pHead.next) {
            return pHead;
        }
        ListNode pPreNode = null;
        ListNode pNextNode = null;
        while (null != pHead) {
            /**
             * 1.next用于记录移除当前结点的链表
             */
            pNextNode = pHead.next;
            /**
             * 2.当前结点(head)的下一个结点指向上一个结点(pre)，即交换两个结点的位置。
             */
            pHead.next = pPreNode;
            /**
             * 3.将交换结点后的链表(head)保存到上一个结点(pre)的链表中。
             */
            pPreNode = pHead;
            /**
             * 移动到下一个结点
             */
            pHead = pNextNode;
        }
        return pPreNode;
    }


    public static void testInstance() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode result = reverseListNode(head);
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

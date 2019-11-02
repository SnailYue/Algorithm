package com.snail.highqualitycode;


public class DeleteNodeOfListNode {

    /**
     * 题目：在O(1)时间删除链表的结点
     * 解题思路：
     * 由于某个链表的结点可以知道链表的下一个结点，所以可以把下一个结点的内容复制到需要删除的结点上覆盖原有的内容，
     * 在把下一个结点删除，就相当于把当前需要删除的删除。
     * 此时需要分三种情况讨论：
     * 1.删除的结点不在链表的尾部。
     * 2.链表只有一个结点。
     * 3.链表中有多个结点，删除最尾部的结点。
     * @param pHead
     * @param pDelNode
     * @return
     */
    public static ListNode deleteNode(ListNode pHead, ListNode pDelNode) {
        if (null == pHead || null == pDelNode) {
            return null;
        }
        /**
         * 删除的结点不在尾部
         */
        if (pDelNode.next != null) {
            ListNode next = pDelNode.next;
            pDelNode.val = next.val;
            pDelNode.next = next.next;
        }
        /**
         * 链表只有一个结点，删除头结点
         */
        else if (pHead == pDelNode) {
            pDelNode = null;
            pHead = null;
        }
        /**
         * 链表中有多个结点，删除尾节点。
         */
        else {
            ListNode cur = pHead;
            while (cur.next != pDelNode) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return pHead;
    }


    public static void testInstance() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        ListNode result = deleteNode(head, head.next.next);
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

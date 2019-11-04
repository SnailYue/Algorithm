package com.snail.highqualitycode;

public class EntryNodeOfNodeLoop {

    /**
     * 题目：如果一个链表中包含环，如何找出环的入口结点。
     * <p>
     * 解题思路：
     * 使用双指针，一个指针fast，每次移动两个结点，一个指针slow每次移动一个结点。
     * 因为存在环，所以两个结点必定在环中的某个结点相遇。
     * 假设相遇的点在环中的z点，那么fast移动的结点为x+2y+z。
     * 而slow移动的点为x+y。
     * 由于fast比slow快一倍，所以x+2y+z = 2(x+y)。即x=z；
     * 在相遇的点，slow距离环的入口还需移动z个结点。此时如果让fast重头开始移动，并速度与slow相同，
     * 那么他到环的入口还需移动x个结点。由于x=z。故两个结点会在入口处相遇。
     *
     * @param head
     * @return
     */
    public static ListNode findEntryNodeOfNodeLoop(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    public static void testInstance() {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;
        System.out.println("result = " + findEntryNodeOfNodeLoop(head).val);
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

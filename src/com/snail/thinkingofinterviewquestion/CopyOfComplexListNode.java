package com.snail.thinkingofinterviewquestion;

public class CopyOfComplexListNode {

    public static RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return null;
        }
        /**
         * 插入新节点
         */
        RandomListNode cur = pHead;
        while (null != cur) {
            RandomListNode clone = new RandomListNode(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        /**
         * 建立random链接
         */
        cur = pHead;
        while (null != cur) {
            RandomListNode clone = cur.next;
            if (null != cur.random) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        /**
         * 拆分
         */
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (null != cur.next) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }


    public static void testInstance() {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;
        RandomListNode<Integer> result = Clone(node1);
        System.out.println("result = " + result.val);
    }

    static class RandomListNode<T> {
        private T val;
        private RandomListNode next;
        private RandomListNode random;

        public RandomListNode(T val) {
            this.val = val;
        }
    }
}

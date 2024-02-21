package com.holelin.leetcode;

import com.holelin.ListNode;

public class 两两交换链表中的节点_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // dummyHead --> 1 --> 2 --> 3 --> NULL  ==> cur.next != null
        // dummyHead --> 1 --> 2 --> 3 --> 4 --> NULL ==> cur.next.next != null
        while (cur.next != null && cur.next.next != null) {
            final ListNode change1 = cur.next;
            final ListNode change2 = cur.next.next;
            cur.next = change2;
            change1.next = change2.next;
            change2.next = change1;
            cur = change1;
        }
        return dummyHead.next;
    }
}

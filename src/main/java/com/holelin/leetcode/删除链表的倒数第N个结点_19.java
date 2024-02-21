package com.holelin.leetcode;

import com.holelin.ListNode;

public class 删除链表的倒数第N个结点_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        int index = n;
        while (index > 0) {
            fast = fast.next;
            index--;
        }
        ListNode slow = dummyHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}

package com.holelin.leetcode;

import com.holelin.ListNode;


public class 反转链表_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}

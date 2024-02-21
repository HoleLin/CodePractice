package com.holelin.leetcode;

import com.holelin.ListNode;

public class 两数相加_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        ListNode result = new ListNode();
        ListNode cur = result;
        boolean isCarry = false;
        while (p != null && q != null) {
            int sum = p.val + q.val;
            final ListNode listNode;
            if (isCarry) {
                sum += 1;
                // 需要进位
                if (sum > 9) {
                    listNode = new ListNode(sum % 10);
                } else {
                    listNode = new ListNode(sum);
                    isCarry = false;
                }
            } else {
                if (sum > 9) {
                    listNode = new ListNode(sum % 10);
                    isCarry = true;
                } else {
                    listNode = new ListNode(sum);
                }
            }
            cur.next = listNode;
            cur = cur.next;
            p = p.next;
            q = q.next;
        }
        while (q != null) {
            final ListNode listNode;
            if (isCarry) {
                int sum = q.val + 1;
                // 需要进位
                if (sum > 9) {
                    listNode = new ListNode(sum % 10);
                } else {
                    listNode = new ListNode(sum);
                    isCarry = false;
                }
            } else {
                listNode = new ListNode(q.val);
            }
            cur.next = listNode;
            cur = cur.next;
            q = q.next;
        }
        while (p != null) {
            final ListNode listNode;
            if (isCarry) {
                int sum = p.val + 1;
                // 需要进位
                if (sum > 9) {
                    listNode = new ListNode(sum % 10);
                } else {
                    listNode = new ListNode(sum);
                    isCarry = false;
                }
            } else {
                listNode = new ListNode(p.val);
            }
            cur.next = listNode;
            cur = cur.next;
            p = p.next;
        }

        // 若两个列表长度不一致,到了最后了还需要进一位
        if (isCarry) {
            cur.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        // l1 = [2,4,3], l2 = [5,6,4]
        final int[] a1 = {9, 9, 9, 9, 9, 9, 9};
        final int[] a2 = {9, 9, 9, 9};
//        final int[] a1 = {2,4,3};
//        final int[] a2 = {5,6,4};
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode cur = l1;
        for (int i : a1) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur = l2;
        for (int i : a2) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        final ListNode result = addTwoNumbers(l1.next, l2.next);
        cur = result;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

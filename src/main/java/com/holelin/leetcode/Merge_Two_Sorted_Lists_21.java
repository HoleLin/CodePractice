package com.holelin.leetcode;

/**
 * ClassName: Merge_Two_Sorted_Lists_21
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/27
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Merge_Two_Sorted_Lists_21 {
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val < l2.val) {
			// 当l1的数小时,将l1.next与l2合并
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			// 当l2的数小或等于时,将l2.next与l1合并
			l2.next = mergeTwoLists1(l1, l2.next);

			return l2;
		}

	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 4};
		int[] nums2 = {1, 3, 4};
		ListNode list1 = new ListNode(0);
		ListNode prev = list1;

		for (int i = 0; i < nums.length; i++) {
			prev.next = new ListNode(nums[i]);
			prev = prev.next;
		}

		ListNode list2 = new ListNode(0);
		prev = list2;

		for (int i = 0; i < nums2.length; i++) {
			prev.next = new ListNode(nums2[i]);
			prev = prev.next;
		}

		ListNode newList = mergeTwoLists1(list1.next, list2.next);
		StringBuilder res = new StringBuilder();
		while (newList.next != null) {
			newList = newList.next;
			res.append(newList.val + "-->");
		}
		System.out.println(res.substring(0, res.length() - 3));
	}
}

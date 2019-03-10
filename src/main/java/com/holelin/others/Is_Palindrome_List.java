package com.holelin.others;

import java.util.Stack;

/**
 * ClassName: Is_Palindrome_List
 * 【题目】
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1，返回true。
 * 1->2->2->1，返回true。
 * 15->6->15，返回true。
 * 1->2->3，返回false
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/10
 */

public class Is_Palindrome_List {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 借助栈来实现 -- 空间复杂度O(n)
	 *
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome1(Node head) {
		if (head == null) {
			return true;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		// 遍历两边链表
		// 第一遍将链表中所有元素压入栈内
		// 第二遍将栈中元素弹出与链表进行比对(从头到尾)
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while (!stack.isEmpty()) {
			if (stack.pop().value != cur.value) {
				return false;
			}
			cur = cur.next;
		}
		return true;
	}

	/**
	 * 采用快慢指针  -- 空间复杂度O(n)
	 * 实际空间缩小一半
	 *
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node fast = head;
		Node slow = head;
		// 使用快慢指针遍历链表
		// 当快指针走到链表尾部,慢指针刚好到链表中间
		// 然后利用栈将链表后半部压入栈中
		// 快指针从新指向头部遍历链表与栈中元素进行比对
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Stack<Node> stack = new Stack<>();
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		fast = head;
		while (!stack.isEmpty()) {
			if (stack.pop().value != fast.value) {
				return false;
			}
			fast = fast.next;
		}
		return true;
	}

	/**
	 * 使用快慢指针,当慢指针走到链表中间时,将后半部分反转进行比对
	 * 空间复杂度为O(1)
	 *
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node fast = head;
		Node slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// -- 此时slow来到链表中间位置
		fast = slow.next;
		slow.next = null;
		// cur 保存当前节点的后续部分,保证后续链表不会丢失
		Node cur = null;
		// 反转后半部分
		while (fast != null) {
			cur = fast.next;
			// 将当前节点与后续节点断开
			fast.next = slow;
			// slow保存后续节点 以便于下次循环接上该节点
			slow = fast;
			fast = cur;
		}
		// 循环退出后 slow指向链表最后一个节点
		cur = slow;
		// 复用fast指针
		fast = head;
		// 标记后半部分与前半部分是否一致
		boolean res = true;
		while (slow != null && fast != null) {
			if (slow.value != fast.value) {
				res = false;
				break;
			}
			slow = slow.next;
			fast = fast.next;
		}
		// 对比完成后 将之前反转的链表,恢复原样
		slow = cur.next;
		cur.next = null;
		while (slow != null) {
			fast = slow.next;
			slow.next = cur;
			cur = slow;
			slow = fast;
		}
		return res;
	}
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}
}

package com.holelin.others;

/**
 * ClassName: Print_Common_Part
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/10
 */

public class Print_Common_Part {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void print(Node list1, Node list2) {
		System.out.println("Common Part:");
		// 同时遍历两个链表
		// 比较两个链表的值,当值相等时打印当前值,若不相等,值较小的链表的指针向后移动一格
		while (list1 != null && list2 != null) {
			if (list1.value > list2.value) {
				list2 = list2.next;
			} else if (list1.value < list2.value) {
				list1 = list1.next;
			} else {
				System.out.println(list1.value + " ");
				list1 = list1.next;
				list2 = list2.next;
			}
		}
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
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);
		printLinkedList(node2);
		print(node1, node2);

	}
}

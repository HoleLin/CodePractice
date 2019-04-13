package com.holelin.others;

/**
 * ClassName: SmallerEqualBigger
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】
 * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整
 * 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于
 * pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于
 * pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，pivot=3。
 * 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满
 * 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
 * 分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做
 * 要求。
 * 思路:
 *      1. 将链表问题转化为数组问题来处理
 *      2. 使用6个指针(三个链表)
 *       1) 构建三个小链表
 *          |--sH 0
 *          |--sT 0 --> 1
 *          |--bH 9
 *          |--bT 9 --> 4 --> 5
 *          |--eH null
 *          |--eT null
 *       2) 将三个小链表连接起来(sH-->sT-->eH-->eT-->bH-->bT)
 *        0 --> 1 --> 9 --> 4 --> 5
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/4/13
 */

public class SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 将链表的Partition转换为数组的Partition
	 *
	 * @param head
	 * @param pivot
	 * @return
	 */
	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		// 循环遍历链表,得到链表的长度
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		// 构建长度与链表一直的数组
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		// 循环将链表的每个节点地址赋给nodeArr数组
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	private static void arrPartition(Node[] nodeArr, int pivot) {
		// 设置两个划分边界small,big
		// 0-small 为小于pivot区域
		// big-nodeArr.length为大于pivot区域
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {

			if (nodeArr[index].value < pivot) {
				// 小于区域划分
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				// 等于pivot区域
				index++;
			} else {
				// 大于pivot区域
				swap(nodeArr, --big, index);
			}
		}

	}

	private static void swap(Node[] nodeArr, int a, int b) {
		Node temp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = temp;
	}
	public static Node listPartition2(Node head, int pivot) {
		// small head
		Node sH = null;
		// small tail
		Node sT = null;
		// equal head
		Node eH = null;
		// equal tail
		Node eT = null;
		// big head
		Node bH = null;
		// big tail
		Node bT = null;
		// save next node
		Node next = null;
		// every node distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {

				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// small and equal reconnect
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// all reconnect
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
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
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
//		head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 4);
		printLinkedList(head1);

	}
}

package com.holelin.others;

import java.util.Stack;

/**
 * ClassName: From_Stack_To_Queue
 * 仅用栈结构实现队列
 * 思路:
 * -- 利用两个栈pushStack和popStack,pushStack用于添加数据,popStack用于弹出数据;
 * -- 操作:将pushStack中的数据倒入popStack
 * -- 倒入条件
 * 1. 当popStack为空
 * 2. 倒入要全部倒入;
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/25
 */

public class From_Stack_To_Queue<E> {
	private Stack<E> pushStack;
	private Stack<E> popStack;

	public From_Stack_To_Queue() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	public void push(E newDta) {
		pushStack.push(newDta);
		importTo();
	}

	private void importTo() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
	}

	public E pop() {

		if (popStack.isEmpty() && pushStack.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		importTo();
		return popStack.pop();
	}

	public E peek() {
		if (popStack.isEmpty() && pushStack.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		importTo();
		return popStack.peek();
	}

	public static void main(String[] args) {
		From_Stack_To_Queue queue=new From_Stack_To_Queue();
		int[] nums = {10, 1, 4, 6, 5, -1, 3, 11, 61, 6};
		for (int i = 0; i <nums.length; i++) {
			queue.push(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(queue.pop()+" ");
		}
	}
}

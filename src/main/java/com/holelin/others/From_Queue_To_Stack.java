package com.holelin.others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: From_Queue_To_Stack
 * 仅用队列结构实现栈结构
 * 思路:
 * -- 利用两个Queue,
 * ---- 当调用push()时,调用queue.add()
 * ---- 当调用pop()时,将queue中的数据保留一个,其余加入help中,再poll queue中的元素(只有一个),最后交换queue和help的引用,返回之前queue.poll()的值
 * ---- 当调用peek(),将queue中的数据保留一个,其余加入help中,再poll queue中的元素(只有一个),在将之前queue.poll()的值添加到help中,最后交换queue和help的引用,返回之前queue.poll()的值
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/25
 */

public class From_Queue_To_Stack<E> {
	private Queue<E> queue;
	private Queue<E> help;

	public From_Queue_To_Stack() {
		queue = new LinkedList<>();
		help = new LinkedList<>();
	}

	public void push(E newData) {
		queue.add(newData);
	}

	public E pop() {
		if (queue.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		while (queue.size() > 1) {
			help.add(queue.poll());
		}
		E ret = queue.poll();
		swap();
		return ret;
	}

	private void swap() {
		Queue<E> tmp = help;
		help = queue;
		queue = tmp;

	}

	public E peek() {
		if (queue.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		while (queue.size() != 1) {
			help.add(queue.poll());
		}
		E ret = queue.poll();
		help.add(ret);
		swap();
		return ret;
	}

	public static void main(String[] args) {
		From_Queue_To_Stack<Integer> stack = new From_Queue_To_Stack();
		int[] nums = {10, 1, 4, 6, 5, -1, 3, 11, 61, 6};

		for (int i = 0; i <nums.length; i++) {
			stack.push(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(stack.pop()+" ");
		}
	}
}

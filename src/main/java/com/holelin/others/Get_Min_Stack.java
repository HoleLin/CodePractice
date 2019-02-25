package com.holelin.others;

import java.util.Random;
import java.util.Stack;

/**
 * ClassName: Get_Min_Stack
 * 问题描述:
 * -- 实现一个特殊的栈,在实现栈的基本功能的基础上,在实现返回栈中最小元素的操作;
 * 要求
 * -- pop,push,getMin操作的时间复杂度为O(1)
 * -- 设计的栈类型可以使用现成的栈结构
 * 解题策略:
 * 1.  创建一个数据栈和一个最小值栈
 * 入栈:
 * -- 若minStack为空(说明两个栈中都没数据),将newData将入minStack中
 * -- 若minStack不为空(说明当前环境下存在最小值),将待入数据和最小值栈的栈顶元素比较
 * ---- 若newData大于等于最小值栈的栈顶元素,将栈顶元素重复入最小值栈
 * ---- 若newData小于最小值栈的栈顶元素,将newData入最小值栈
 * -- 最后将newData入数据栈
 * 入栈:
 * -- 检查栈是否为空栈
 * -- 不为空栈情况下,两个栈同时出栈,并返回数据栈栈顶元素
 * tips: 此时两个栈的大小是一样大的
 * 2. 创建一个数据栈和一个最小值栈
 * 入栈:
 * -- 当minStack为空,将newData将入minSta中
 * -- 若minStack不为空,比较newData与minStack的栈顶元素
 * ---- 若newData小于栈顶元素,将newData入minStack
 * ---- 若newData大于栈顶元素,不做任何操作
 * -- 最后将newData入数据栈
 * tips : 两个栈的大小可能不一致
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/25
 */

public class Get_Min_Stack<E extends Comparable<E>> {
	/**
	 * 存放数据的栈
	 */
	private Stack<E> dataStack;
	/**
	 * 存放最小值的栈
	 */
	private Stack<E> minStack;

	public Get_Min_Stack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(E newData) {
		if (minStack.isEmpty()) {
			minStack.push(newData);
		} else if (newData.compareTo(minStack.peek()) >= 0) {
			minStack.push(minStack.peek());
		} else {
			minStack.push(newData);
		}
		dataStack.push(newData);
	}

	public E pop() {
		if (dataStack.isEmpty() || minStack.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		E ret = dataStack.pop();
		minStack.pop();
		return ret;
	}

	public E getMin() {
		if (minStack.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		return minStack.peek();
	}

	public E peek() {
		if (dataStack.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		return dataStack.peek();
	}


	public void push2(E newData) {
		if (minStack.isEmpty()) {
			minStack.push(newData);
		} else if (newData.compareTo(minStack.peek()) <= 0) {
			minStack.push(newData);
		}
		dataStack.push(newData);
	}

	public E pop2() {
		if (dataStack.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		E ret = dataStack.pop();
		if (ret.compareTo(minStack.peek()) == 0) {
			minStack.pop();
		}
		return ret;
	}

	public E getMin2() {
		if (minStack.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		return minStack.peek();
	}

	public static void main(String[] args) {
		Get_Min_Stack<Integer> stack = new Get_Min_Stack<>();
		Get_Min_Stack<Integer> stack2 = new Get_Min_Stack<>();
		int[] nums = {10, 1, 4, 6, 5, -1, 3, 11, 61, 6};
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			stack.push(nums[i]);
			stack2.push2(nums[i]);
		}
		for (int i = 0; i < size; i++) {
			System.out.println("Min1: " + stack.getMin()+" -- "+"Min2: " + stack2.getMin2());
			System.out.println("Top1: " + stack.pop()+" -- "+"Top2: " + stack2.pop2());
		}
	}
}

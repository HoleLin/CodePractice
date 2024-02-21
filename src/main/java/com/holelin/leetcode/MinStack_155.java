package com.holelin.leetcode;

import java.util.Stack;

public class MinStack_155 {
    Stack<Integer> a, b;

    /**
     * initialize your data structure here.
     */
    public MinStack_155() {
        a = new Stack<Integer>();
        b = new Stack<Integer>();
    }

    public void push(int x) {
        a.push(x);
        // 若辅助栈为空或者辅助栈栈顶元素比当前元素大,则将当前元素压入辅助栈
        if (b.isEmpty() || b.peek() >= x) {
            b.push(x);
        }
    }

    public void pop() {
        // 若主栈栈顶元素与辅助栈栈顶元素一样则表示辅助栈也需要出栈
        if (!b.isEmpty() && a.peek().equals(b.peek())) {
            b.pop();
        }
        if (!a.isEmpty()) {
            a.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}

package com.holelin.leetcode;

import java.util.ArrayDeque;

public class 删除字符串中的所有相邻重复项_1047 {
    public static String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!deque.isEmpty() && deque.peek() == aChar) {
                deque.pop();
            } else {
                deque.push(aChar);
            }
        }
        // 将deque中的数据弹出
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0, deque.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbarc"));
    }
}

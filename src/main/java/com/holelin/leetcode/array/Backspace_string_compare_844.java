package com.holelin.leetcode.array;

import java.util.Objects;
import java.util.Stack;

public class Backspace_string_compare_844 {
    public boolean backspaceCompare2(String s, String t) {
        final String t2 = getCharacters2(t);
        final String s2 = getCharacters2(s);
        return Objects.equals(t2, s2);
    }

    private static String getCharacters2(String s) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        final Stack<Character> stack2 = getCharacters(t);
        final Stack<Character> stack1 = getCharacters(s);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack2.empty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private static Stack<Character> getCharacters(String s) {
        final Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            final char c = s.charAt(i);
            if (c == '#') {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        return stack1;
    }
}

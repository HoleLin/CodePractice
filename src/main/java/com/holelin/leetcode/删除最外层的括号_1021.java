package com.holelin.leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

public class 删除最外层的括号_1021 {

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 1;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 2) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // (1(2)2(2)2)1(1(2)2)1
        // (2)2(2)2(2)2
        // ()()()

        // (1(2)2(2)2)1(1(2)2)1(1(2)2(2(3)3)2)1
        // (2)2(2)2(2)2(2)2(2(3)3)2
        // ()()()()(())

        // (1)1(1)1
        //
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}

package com.holelin.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class 括号的最大嵌套深度_1614 {

    public static int maxDepth(String s) {
        final int length = s.length();
        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            }
            if (s.charAt(i) == ')') {
                depth--;
            }
            maxDepth = Math.max(depth, maxDepth);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(()(()))"));
        System.out.println(maxDepth("((())())"));
    }
}

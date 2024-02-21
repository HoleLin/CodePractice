package com.holelin.leetcode.backtracing.split;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串_131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        LinkedList<String> path = new LinkedList<>();
        backtracing(result, path, s, 0);
        return result;
    }

    private static void backtracing(List<List<String>> result, LinkedList<String> path, String s, int startIndex) {
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                final String str1 = s.substring(startIndex, i + 1);
                path.addLast(str1);
            } else {
                continue;
            }
            backtracing(result, path, s, i + 1);
            path.removeLast();
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("cdd"));
    }
}

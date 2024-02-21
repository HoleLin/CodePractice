package com.holelin.leetcode.backtracing.combine;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合_17 {

    public static List<String> letterCombinations(String digits) {
        final ArrayList<String> result = new ArrayList<>();
        final String[] map = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        backtracing(result, path, digits, map, 0);
        return result;
    }

    private static void backtracing(ArrayList<String> result, StringBuilder path,
                                    String digits, String[] map, int index) {
        // index是digits的下标
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        final String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtracing(result, path, digits, map, index + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("29"));
    }
}

package com.holelin.leetcode.kmp;

public class 重复的子字符串_459 {
    public boolean repeatedSubstringPattern(String s) {
        final int[] next = new int[s.length()];
        // 构建next数组
        getNext(next, s);
        // 获取最短子串
        final int length = s.length();
        return next[length - 1] != 0 && length % (length - next[length - 1]) == 0;
    }

    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}

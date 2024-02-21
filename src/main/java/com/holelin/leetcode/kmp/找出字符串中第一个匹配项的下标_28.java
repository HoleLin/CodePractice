package com.holelin.leetcode.kmp;

import java.util.Arrays;

public class 找出字符串中第一个匹配项的下标_28 {

    public static int strStr(String haystack, String needle) {
        final int length = needle.length();
        if (length == 0) {
            return 0;
        }
        final int[] next = new int[length];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 文本串s里出现了模式串t
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    public static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
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

    public static void main(String[] args) {
        final String needle = "aabaaac";
        final int[] next = new int[needle.length()];
        getNext(next, needle);
        System.out.println(Arrays.toString(next));
        System.out.println(strStr("aabaaabaaac", needle));
    }
}

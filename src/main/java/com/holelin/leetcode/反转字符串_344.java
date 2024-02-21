package com.holelin.leetcode;

import java.util.Arrays;

public class 反转字符串_344 {
    public static void reverseString(char[] s) {
        if (s != null && s.length > 0) {
            int p = 0;
            int q = s.length - 1;
            while (p < q) {
                char temp = s[p];
                s[p] = s[q];
                s[q] = temp;
                p++;
                q--;
            }
        }
    }

    public static void main(String[] args) {
        final char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

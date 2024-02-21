package com.holelin.others;

public class 左旋转字符串 {

    public static String reverseLeftWords(String s, int n) {
        if (n <= 0) {
            return s;
        }
        final char[] chars = s.toCharArray();
        if (n > chars.length) {
            n = chars.length;
        }
        final char[] reverseChars = new char[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            reverseChars[i] = chars[i];
        }
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        sb.append(reverseChars);
        return sb.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

    public static String reverseLeftWords3(String s, int n) {
        final char[] chars = s.toCharArray();
        reverseLeftWord(chars, 0, chars.length - 1);
        reverseLeftWord(chars, 0, chars.length - 1 - n);
        reverseLeftWord(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    public static void reverseLeftWord(char[] s, int start, int end) {
        int p = start;
        int q = end;
        while (p <= q) {
            final char temp = s[p];
            s[p] = s[q];
            s[q] = temp;
            p++;
            q--;
        }
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords3("abcdefg", 2));
    }
}

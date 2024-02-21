package com.holelin.leetcode;

public class 反转字符串中的单词_51 {

    public static String reverseWords(String s) {
        // 移除多余空格
        final StringBuilder sb = removeSpace(s);
        // 翻转字符串
        reverseString(sb, 0, sb.length() - 1);
        // 翻转单词
        reverseWord(sb);
        return sb.toString();
    }

    private static void reverseWord(StringBuilder sb) {
        final int length = sb.length();
        int start = 0;
        int end = 1;
        while (start < length) {
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        final char space = ' ';
        while (s.charAt(start) == space) {
            start++;
        }
        while (s.charAt(end) == space) {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != space || sb.charAt(sb.length() - 1) != space) {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));


    }
}

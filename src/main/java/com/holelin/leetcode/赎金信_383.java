package com.holelin.leetcode;

public class 赎金信_383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        final int[] a1 = new int[26];
        final char[] chars = ransomNote.toCharArray();
        final char[] chars1 = magazine.toCharArray();
        for (char c : chars1) {
            a1[c - 'a']++;
        }
        for (char aChar : chars) {
            if (a1[aChar - 'a'] <= 0) {
                return false;
            } else {
                a1[aChar - 'a']--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
}

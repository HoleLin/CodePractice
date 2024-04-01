package com.holelin.leetcode.string;

public class 最长公共前缀_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String maxCommonPrefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (i + 1 < strs.length) {
               maxCommonPrefix = commonPrefix(maxCommonPrefix, strs[i + 1]);
            }
        }
        return maxCommonPrefix;
    }

    public static String commonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        final int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }
}

package com.holelin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词_242 {
    public static boolean isAnagram(String s, String t) {
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();
        final HashMap<String, Integer> map = new HashMap<>();
        for (char sChar : sChars) {
            final String c = String.valueOf(sChar);
            if (map.containsKey(c)) {
                final Integer integer = map.get(c);
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char sChar : tChars) {
            final String c = String.valueOf(sChar);
            if (map.containsKey(c)) {
                final Integer integer = map.get(c);
                final int newValue = integer - 1;
                if (newValue == 0) {
                    map.remove(c);
                } else {
                    map.put(c, newValue);
                }
            } else {
                map.put(c, 1);
            }
        }
        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();

        final int[] array = new int['z' + 1];
        for (char sChar : sChars) {
            array[sChar] += 1;
        }
        for (char sChar : tChars) {
            array[sChar] -= 1;
        }
        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count : record) {
            if (count != 0) {
                // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("zlap", "kcqx"));
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
}


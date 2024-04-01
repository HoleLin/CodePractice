package com.holelin.leetcode.string;

import java.util.HashMap;

public class isomorphic_strings_205 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            final char sChar = s.charAt(i);
            final char tChar = t.charAt(j);
            if (!map1.containsKey(sChar)) {
                map1.put(sChar, tChar); // map1保存 s[i] 到 t[j]的映射
            }
            if (!map2.containsKey(tChar)) {
                map2.put(tChar, sChar); // map2保存 t[j] 到 s[i]的映射
            }
            // 无法映射，返回 false
            if (map1.get(sChar) != tChar || map2.get(tChar) != sChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(isIsomorphic("foo", "bar"));
//        System.out.println(isIsomorphic("paper", "title"));
//        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}

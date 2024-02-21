package com.holelin.leetcode;

public class Backspace_String_Compare_844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ac"));
    }

    public static boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        final int sLength = sChars.length;
        final int tLength = tChars.length;

        replaceSymbol(sChars, '#');
        replaceSymbol(tChars, '#');

        // 对齐长度
        if (sLength > tLength) {
            // 将t补充#来
            char[] temp = new char[sLength];
            for (int i = 0; i < sLength; i++) {
                if (i < tLength) {
                    temp[i] = tChars[i];
                } else {
                    temp[i] = '\0';
                }
            }

        } else if (sLength < tLength) {

        } else {

        }
        return true;
    }

    public static void replaceSymbol(char[] arr, char symbol) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < arr.length; fastIndex++) {
            if (arr[fastIndex] == symbol) {
                arr[fastIndex] = '\0';
                arr[slowIndex] = '\0';
                slowIndex--;
            } else {
                slowIndex = fastIndex;
            }
        }
    }
}

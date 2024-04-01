package com.holelin.leetcode.string;

public class Add_binary_67 {

    public static String addBinary(String a, String b) {
        final StringBuilder sb = new StringBuilder();
        // 填充0 补齐较短的字符串
        if (a.length() > b.length()) {
            Integer len = a.length();
            b = fillZero(b, len);
        } else if (a.length() < b.length()) {
            Integer len = b.length();
            a = fillZero(a, len);
        }
        final int length = a.length();
        boolean plusOne = false;
        char zeroChar = '0';
        char oneChar = '1';
        for (int i = length - 1; i >= 0; i--) {
            final boolean zero = a.charAt(i) == zeroChar && b.charAt(i) == zeroChar;
            final boolean one = (a.charAt(i) == oneChar && b.charAt(i) == zeroChar) ||
                    (a.charAt(i) == zeroChar && b.charAt(i) == oneChar);
            final boolean plus = a.charAt(i) == oneChar && b.charAt(i) == oneChar;
            char addChar = ' ';
            if (plusOne) {
                if (zero) {
                    addChar = '1';
                    plusOne = false;
                } else if (one) {
                    addChar = '0';
                } else if (plus) {
                    addChar = '1';
                }
            } else {
                if (zero) {
                    addChar = '0';
                } else if (one) {
                    addChar = '1';
                } else if (plus) {
                    addChar = '0';
                    plusOne = true;
                }
            }
            sb.append(addChar);
            if (i == 0 && plusOne) {
                sb.append('1');
            }
        }
        return sb.reverse().toString();
    }

    public static String fillZero(String str, Integer len) {
        final StringBuilder sb = new StringBuilder();
        final int zeroLength = len - str.length();
        for (int i = 0; i < zeroLength; i++) {
            sb.append('0');
        }
        return sb.append(str).toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("1", "1111"));
        // a = "1010", b = "1011"
        System.out.println(addBinary("1010", "1011"));
    }
}

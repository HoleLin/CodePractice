package com.holelin.leetcode.string;

import java.util.HashMap;

public class Excel_sheet_column_168 {

    public static String convertToTitle(int columnNumber) {
        int N = 26;
        final StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % N + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2147483647));
    }
}

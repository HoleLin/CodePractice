package com.holelin.leetcode.string;

public class Excel_sheet_column_number_171 {
    public static int titleToNumber(String columnTitle) {
        final char[] chars = columnTitle.toCharArray();
        int index = 0;
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            final int aChar = chars[i] - 'A' + 1;
            result = (int) (result + aChar * Math.pow(26, index));
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}

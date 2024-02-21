package com.holelin.others;

public class 替换空格 {
    public static String replaceSpace(String s) {
        if (s.length() == 0) {
            return s;
        }
        final char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");

            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}

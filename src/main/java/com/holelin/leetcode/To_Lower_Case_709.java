package com.holelin.leetcode;

import java.util.Arrays;

/**
 * ClassName: To_Lower_Case_709
 * Implement function To_Lower_Case_709() that has a string parameter str, and returns the same string in lowercase.
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/20
 */

public class To_Lower_Case_709 {
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A' && chars[i]<= 'Z') {
                chars[i] += 32;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("HADJKHASDH"));
        System.out.println(toLowerCase("asdjasASDASDdasd"));
        System.out.println(toLowerCase("asdjasjJJJJJ"));
    }
}

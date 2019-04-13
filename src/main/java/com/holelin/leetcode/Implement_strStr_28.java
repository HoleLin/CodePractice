package com.holelin.leetcode;

/**
 * ClassName: Implement_strStr_28
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/3
 */

public class Implement_strStr_28 {
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return 0;
		}
		if (haystack.length() < needle.length()) {
			return -1;
		}
		//
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j;
			for (j = 0; j < needle.length(); j++) {
				if (needle.charAt(j) != haystack.charAt(j + i)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello","ll"));
		System.out.println(strStr("aaaaa","bba"));


	}
}

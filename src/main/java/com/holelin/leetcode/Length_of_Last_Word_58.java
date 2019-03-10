package com.holelin.leetcode;

/**
 * ClassName: Length_of_Last_Word_58
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/3
 */

public class Length_of_Last_Word_58 {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != ' ') {
				if (i != 0 && s.charAt(i - 1) == ' ') {
					res = 1;
				} else {
					++res;
				}
			}
		}
		return res;


//		char[] tempChars = s.toCharArray();
//
//		if (tempChars[0] == ' ') {
//			s = s.substring(1);
//		}
//		if (tempChars[tempChars.length - 1] == ' ') {
//			s = s.substring(0, s.length() - 1);
//		}
//		for (int i = s.length() - 1; i >= 0; i--) {
//			char cur = s.charAt(i);
//			if (cur == ' ') {
//				return s.length() - 1 - i;
//			}
//		}
//		return s.length();
	}

	public static void main(String[] args) {
		String s = "HelloWorld";
		String s1 = " a";
		String s2 = "Hello World";
		String s3 = "this is my apple";
		String s4 = "Today is a nice day";
		String s5 = "a ";
		String s6 = " ";
		System.out.println(lengthOfLastWord(s));
		System.out.println(lengthOfLastWord(s1));
		System.out.println(lengthOfLastWord(s2));
		System.out.println(lengthOfLastWord(s3));
		System.out.println(lengthOfLastWord(s4));
		System.out.println(lengthOfLastWord(s5));
		System.out.println(lengthOfLastWord(s6));
		lengthOfLastWord(s6);
	}
}

package com.holelin.leetcode;

/**
 * ClassName: Palindrome_Number_9
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/27
 */

public class Palindrome_Number_9 {
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int copyx = x;
		int temp = 0;
		while (x != 0) {
			temp = temp * 10 + x % 10;
			x /= 10;
			System.out.println(temp);
		}

		return temp == copyx;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

}

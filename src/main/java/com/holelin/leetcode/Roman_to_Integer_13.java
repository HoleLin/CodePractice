package com.holelin.leetcode;

import java.util.HashMap;

/**
 * ClassName: Roman_to_Integer_13
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * -------------------------------------
 * Runtime: 40 ms, faster than 76.84% of Java online submissions for Roman to Integer.
 * Memory Usage: 39.8 MB, less than 7.91% of Java online submissions for Roman to Integer.
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/27
 */

public class Roman_to_Integer_13 {
	private static HashMap<Character, Integer> mMap = new HashMap<>();

	static {
		mMap.put('I', 1);
		mMap.put('V', 5);
		mMap.put('X', 10);
		mMap.put('L', 50);
		mMap.put('C', 100);
		mMap.put('D', 500);
		mMap.put('M', 1000);
	}

	public static int romanToInt(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!mMap.containsKey(s.charAt(i))) {
				throw new IllegalArgumentException("Input error!");
			}
			// 获取当前数
			Integer cur = mMap.get(s.charAt(i));
			// 用当前数cur与下一个数next进行比较
			// 若cur大于next -- 和加上cur
			// 若cur小于next -- 和减去cur
			if (i+1<s.length()) {
				Integer next = mMap.get(s.charAt(i + 1));
				if (cur >= next) {
					ret += cur;
				} else {
					ret -= cur;
				}
			}else {
				// 判断到最后一个数时,没有next,直接加上cur
				ret+=cur;
			}
		}
		return ret;

	}

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
}

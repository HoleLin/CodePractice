package com.holelin.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_integer_13 {
    static HashMap<Character, Integer> MAP = new HashMap<>();

    static {
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) {
            return sum;
        }
        final char[] chars = s.toCharArray();
        Integer lastValue = MAP.get(chars[chars.length - 1]);
        sum += lastValue;
        for (int i = chars.length - 2; i >= 0; i--) {
            // I can be placed before V (5) and X (10) to make 4 and 9.
            // X can be placed before L (50) and C (100) to make 40 and 90.
            // C can be placed before D (500) and M (1000) to make 400 and 900.
            final Integer currentValue = MAP.get(chars[i]);
            if (currentValue >= lastValue) {
                sum += currentValue;
            } else {
                sum -= currentValue;
            }
            lastValue = currentValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}

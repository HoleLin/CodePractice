package com.holelin.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Plus_one_66 {
    public static int[] plusOne(int[] digits) {
        final ArrayList<Integer> reverseDigits = new ArrayList<>();
        for (int i = digits.length - 1, j = 0; i >= 0; i--, j++) {
            reverseDigits.add(digits[i]);
        }
        boolean carry = true;
        for (int i = 0; i < reverseDigits.size(); i++) {
            if (carry) {
                final int digit = reverseDigits.get(i) + 1;
                if (digit == 10) {
                    reverseDigits.set(i, 0);
                    carry = true;
                    // 如果i为最后一个元素则需在末尾添加一个1
                    if (i == reverseDigits.size() - 1) {
                        reverseDigits.add(1);
                        break;
                    }
                } else {
                    reverseDigits.set(i, digit);
                    carry = false;
                }
            }else {
                break;
            }
        }

        Collections.reverse(reverseDigits);
        return reverseDigits.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}

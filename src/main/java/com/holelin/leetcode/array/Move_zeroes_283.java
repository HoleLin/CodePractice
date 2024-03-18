package com.holelin.leetcode.array;

import java.util.Arrays;

public class Move_zeroes_283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex <= nums.length - 1; fastIndex++) {
            if (nums[fastIndex] != 0) {
                int temp = nums[slowIndex];
                nums[slowIndex++] = nums[fastIndex];
                nums[fastIndex] = temp;
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex <= nums.length - 1; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        for (int i = slowIndex; i <= nums.length - 1; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 1};
        int[] nums3 = {1, 0};
        moveZeroes(nums);
        moveZeroes(nums2);
        moveZeroes(nums3);
    }
}

package com.holelin.leetcode.array;

public class Search_insert_35 {
    public static int searchInsert(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            final int current = nums[i];
            if (current >= target) {
                result = i;
                break;
            }
            if (i == nums.length - 1 && result == -1) {
                result = nums.length;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 99));
    }
}

package com.holelin.leetcode.two_point;

public class 只出现一次的数字_136 {
    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int p = 0;
        int q = nums.length - 1;
        int result = 0;
        while (p < q) {
            if (nums[p] == nums[q]) {
                p++;
            }
            if (p == q) {
                result = nums[p];
            }
            q--;
        }
        return result;
    }

    public static void main(String[] args) {
        final int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}

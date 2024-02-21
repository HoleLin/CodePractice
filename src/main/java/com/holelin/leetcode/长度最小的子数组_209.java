package com.holelin.leetcode;

public class 长度最小的子数组_209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end;
        int result = Integer.MAX_VALUE;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum = sum - nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}

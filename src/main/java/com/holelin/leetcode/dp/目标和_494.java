package com.holelin.leetcode.dp;

public class 目标和_494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 此时没有⽅案
        if (target > sum) {
            return 0;
        }
        // 此时没有⽅案
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int bagWeight = (sum - target) / 2;
        final int[] dp = new int[bagWeight + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagWeight; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1000}, -1000));
    }
}

package com.holelin.leetcode.dp;

public class 爬楼梯_70 {
    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        // dp[i] = dp[i-1] + dp[i-2];
        final int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }
        // dp[i] = dp[i-1] + dp[i-2];
        final int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}

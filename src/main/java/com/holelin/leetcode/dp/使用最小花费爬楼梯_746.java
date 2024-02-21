package com.holelin.leetcode.dp;

public class 使用最小花费爬楼梯_746 {

    public int minCostClimbingStairs(int[] cost) {
        // dp[i]表示到达第i个台阶所花费的最少体⼒
        // dp[i] = min(dp[i-1],dp[i-2]) + cost[i]
        // dp[0] = cost[0]
        // dp[1] = cost[1]
        final int n = cost.length;
        final int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        // 最后一步 无需要花费
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        // dp[i]表示到达第i个台阶所花费的最少体⼒
        // dp[i] = min(dp[i-1],dp[i-2]) + cost[i]
        // dp[0] = cost[0]
        // dp[1] = cost[1]
        final int n = cost.length;
        final int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int sum = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        // 最后一步 无需要花费
        return Math.min(dp[0], dp[1]);
    }

}

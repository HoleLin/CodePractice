package com.holelin.leetcode.dp;

import java.util.Arrays;

public class 整数拆分_343 {

    public static int integerBreak(int n) {
        // dp[i] 拆分数字i,可以得到的最大乘积
        // i 拆分为两个数时,存在 j * (i - j)
        // i 拆分为三个数及以上时,存在 j * dp[i - j]
        // dp[i] = Math.max(j * (i - j), j * dp[i - j])
        final int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}

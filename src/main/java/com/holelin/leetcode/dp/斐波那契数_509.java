package com.holelin.leetcode.dp;

public class 斐波那契数_509 {

    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        /**
         * 1.  确定dp数组（dp table）以及下标的含义
         * 2.  确定递推公式
         * 3.  dp数组如何初始化
         * 4.  确定遍历顺序
         * 5.  举例推导dp数组
         */
        // dp[i]表示斐波拉契数列的第i个元素的值
        final int[] dp = new int[n + 1];
        // dp数组初始化值
        dp[0] = 0;
        dp[1] = 1;
        // 从前到后遍历
        for (int i = 2; i <= n; i++) {
            // 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        final int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}

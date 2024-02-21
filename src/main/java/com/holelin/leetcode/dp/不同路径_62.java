package com.holelin.leetcode.dp;

public class 不同路径_62 {

    public int uniquePaths(int m, int n) {
        // dp[i][j] ：表⽰从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
        // dp[1][1] = dp[0][1] + dp[1][0] ==> dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        final int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

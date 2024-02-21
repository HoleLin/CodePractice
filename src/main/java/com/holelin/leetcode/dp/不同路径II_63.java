package com.holelin.leetcode.dp;

public class 不同路径II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp[i][j] ：表⽰从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        // dp[1][1] = dp[0][1] + dp[1][0] ==> dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        final int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

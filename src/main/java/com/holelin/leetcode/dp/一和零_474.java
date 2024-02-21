package com.holelin.leetcode.dp;

public class 一和零_474 {
    public int findMaxForm(String[] strs, int m, int n) {

        final int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            final int x = countChar(str, '0');
            final int y = countChar(str, '1');
            for (int i = m; i >= x; i--) {
                for (int j = n; i >= y; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - x][j - y] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int countChar(String str, char c) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        final char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (c == aChar) {
                count++;
            }
        }
        return count;
    }
}

package com.holelin.leetcode.dp;

public class 不同的二叉搜索树_96 {
    public int numTrees(int n) {
        // dp[i] 表示i个节点有dp[i]中互不相同的二叉搜索树
        // dp[0] = 1, dp[1] = 1, dp[2] = 2, dp[3]=5
        // dp[3] = 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3位头结点搜索树的数量
        // 元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树的数量 * 左子树有0个元素的数量
        // 元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树的数量 * 左子树有1个元素的数量
        // 元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树的数量 * 左子树有2个元素的数量
        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0 * dp[2]
        // = 2 + 1 + 2 = 5
        // dp[i] += dp[ j-1 ] * dp[ i-j]
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

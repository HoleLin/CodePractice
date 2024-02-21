package com.holelin.leetcode.dp;

import java.util.Arrays;

public class 背包问题_01背包 {

    public static void bag1() {
        final int[] weight = {1, 3, 4};
        final int[] value = {15, 20, 30};
        int bagWeight = 4;

        final int[][] dp = new int[weight.length + 1][bagWeight + 1];
        // dp[i][j] 表示从0~i物品任取,放进容量为j的背包,价值总和最大是多少
        // 放入物品i: dp[i-1][j]
        // 不放入物品i: dp[i - 1][j - weight[i]] + value[i]
        // 初始化dp数组
        for (int j = bagWeight; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }
        // 遍历物品
        for (int i = 1; i < weight.length; i++) {
            // 遍历背包
            for (int j = 1; j <= bagWeight; j++) {
                // 背包容量j小于物品i的重量,则放不进背包
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static void bag2() {
        final int[] weight = {1, 3, 4};
        final int[] value = {15, 20, 30};
        int bagWeight = 4;

        final int[] dp = new int[bagWeight + 1];
        // dp[j] 放进容量为j的背包,价值总和最大是多少
        // dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i])
        // 初始化
        for (int j = bagWeight; j >= weight[0]; j--) {
            dp[j] = dp[j - weight[0]] + value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));

    }

    public static void main(String[] args) {
        bag1();
        bag2();
    }
}

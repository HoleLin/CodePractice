package com.holelin.leetcode.dp;

import java.util.Arrays;

public class 最后一块石头的重量II_1049 {

    public static int lastStoneWeightII(int[] stones) {
        if (stones.length < 1) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int bagWeight = sum / 2;

        final int[] dp = new int[bagWeight + 1];
        for (int stone : stones) {
            for (int j = bagWeight; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - 2 * dp[bagWeight];
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}

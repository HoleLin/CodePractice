package com.holelin.leetcode.dp;

public class 分割等和子集_416 {

    public static boolean canPartition(int[] nums) {
        // 套用01背包解法
        // nums数组表示重量与价值相同的物品数组
        // 背包容量则是nums数组总和的一半 sum/2
        // dp[j] 表示容量为j的背包,可以装进最大价值的物品
        // dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i])
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int bagWeight = sum / 2;

        final int[] dp = new int[bagWeight + 1];
        // 遍历数组
        for (int num : nums) {
            for (int j = bagWeight; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[bagWeight] == bagWeight;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 2, 5}));
    }
}

package com.holelin.leetcode.array.sliding_window;

public class Minimum_size_subarray_sum_209 {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // 子序列的数值之和
        int sum = 0;
        // 子序列的起始位置
        int start = 0;
        // 子序列的结束位置
        int end;
        // 最终结果
        int result = Integer.MAX_VALUE;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            // 这里使用while,每次更新start(起始位置),并不断比较子序列是否符合条件
            while (sum >= target) {
                // end - start + 1 获取子序列的长度
                // 比较获取最小的子序列
                result = Math.min(result, end - start + 1);
                // 这里体现出滑动窗口的精髓,不断变换start(子序列的起始位置)
                sum = sum - nums[start++];
            }
        }
        // 如果result没有被赋值的话,就返回0,说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}

package com.holelin.leetcode.array.sliding_window;

public class Maximum_average_subarray_643 {
    public static double findMaxAverage(int[] nums, int k) {
        double result = Double.NEGATIVE_INFINITY;
        int windowLeft = 0;
        int windowRight;
        double sum = 0;
        for (windowRight = 0; windowRight < nums.length; windowRight++) {
            sum += nums[windowRight];
            while (windowRight - windowLeft + 1 >= k) {
                double average = sum / k;
                result = Math.max(result, average);
                sum -= nums[windowLeft++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}

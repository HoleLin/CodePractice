package com.holelin.leetcode.array.sliding_window;

public class Number_of_sub_arrays_of_size_k_1343 {
    /**
     * Example 1:
     * <p>
     * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
     * Output: 3
     * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
     * All other sub-arrays of size 3 have averages less than 4 (the threshold).
     *
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int windowLeft = 0;
        int windowRight;
        int windowSum = 0;
        for (windowRight = 0; windowRight < arr.length; windowRight++) {
            windowSum += arr[windowRight];
            while (windowRight - windowLeft + 1 >= k) {
                if (windowSum / k >= threshold) {
                    result++;
                }
                windowSum -= arr[windowLeft++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}

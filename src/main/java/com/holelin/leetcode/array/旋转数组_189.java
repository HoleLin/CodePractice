package com.holelin.leetcode.array;

public class 旋转数组_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 反转整个数组
        reverse(nums, 0, n - 1);
        // 反转区间为前k的数组
        reverse(nums, 0, k - 1);
        // 反转区间为k到末尾的数组
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}

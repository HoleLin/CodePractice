package com.holelin.leetcode;

public class 二分查找_704 {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                // 在左区间,收缩右边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 在右区间,收缩左边界
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}

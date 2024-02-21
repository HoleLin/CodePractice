package com.holelin.leetcode.two_point;

public class 搜索插入位置_35 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                index++;
            }

        }
        return index;
    }

    public static int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        final int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));

    }
}

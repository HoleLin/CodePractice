package com.holelin.leetcode.array;

public class Remove_duplicates_from_sorted_array_26 {
    /**
     * 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 1;
        }
        int slowIndex = 0;
        int target = nums[slowIndex];
        for (int fastIndex = 0; fastIndex <=nums.length - 1; fastIndex++) {
            if (target != nums[fastIndex]) {
                nums[++slowIndex] = nums[fastIndex];
                target = nums[slowIndex];
            }
        }
        return slowIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,5,6,6,6,6};
        System.out.println(removeDuplicates(nums));
    }
}

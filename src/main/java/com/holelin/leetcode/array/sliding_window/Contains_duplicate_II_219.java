package com.holelin.leetcode.array.sliding_window;

import java.util.HashSet;

public class Contains_duplicate_II_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        HashSet<Integer> set = new HashSet<>();
        while (right < nums.length) {
            final int num = nums[right];
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
            while (set.size() > k) {
                set.remove(nums[left++]);
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        // nums = [1,2,3,1], k = 3
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        int[] nums1 = {1, 0, 1, 1};
        k = 1;
        System.out.println(containsNearbyDuplicate(nums1, k));

        int[] nums2 = {1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println(containsNearbyDuplicate(nums2, k));
    }
}

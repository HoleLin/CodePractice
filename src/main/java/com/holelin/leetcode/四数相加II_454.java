package com.holelin.leetcode;

import java.util.HashMap;

public class 四数相加II_454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                final int sum = i + j;
                if (map.containsKey(sum)) {
                    final Integer integer = map.get(sum);
                    map.put(sum, integer + 1);
                } else {
                    map.put(sum, 1);
                }

            }
        }
        int count = 0;
        for (int x : nums3) {
            for (int y : nums4) {
                final int key = 0 - x - y;
                if (map.containsKey(key)) {
                    count += map.get(key);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        final int[] nums1 = {1, 2};
        final int[] nums2 = {-2, -1};
        final int[] nums3 = {-1, 2};
        final int[] nums4 = {0, 2};
        System.out.println(fourSumCount(
                nums1,
                nums2,
                nums3,
                nums4
        ));
    }
}


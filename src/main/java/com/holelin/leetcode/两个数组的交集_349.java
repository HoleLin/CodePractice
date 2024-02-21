package com.holelin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 两个数组的交集_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        final HashSet<Integer> set = new HashSet<>();
        final HashSet<Integer> tempSet = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                tempSet.add(j);
            }
        }
        final int[] result = new int[tempSet.size()];
        int index = 0;
        for (Integer integer : tempSet) {
            result[index++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}

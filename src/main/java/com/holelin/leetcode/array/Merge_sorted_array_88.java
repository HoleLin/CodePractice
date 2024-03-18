package com.holelin.leetcode.array;

import java.util.Arrays;

public class Merge_sorted_array_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 取出nums1中前m元素放到新的数组中
        int[] nums_m = new int[m];
        for (int i = 0; i < m; i++) {
            nums_m[i] = nums1[i];
        }
        int left_m = 0;
        int left_n = 0;
        int index = 0;
        while (left_m < nums_m.length && left_n < nums2.length) {
            // 较小的数据先放入nums1中
            if (nums_m[left_m] > nums2[left_n]) {
                nums1[index] = nums2[left_n];
                left_n++;
            } else {
                nums1[index] = nums_m[left_m];
                left_m++;
            }
            index++;
        }
        // 将剩余的数据放入num1中
        if (left_m < nums_m.length) {
            for (int i = left_m; i < nums_m.length; i++) {
                nums1[index] = nums_m[i];
                index++;
            }
        }
        if (left_n < nums2.length) {
            for (int i = left_n; i < nums2.length; i++) {
                nums1[index] = nums2[i];
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 0, n = 1;
//        merge(nums1, m, nums2, n);

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1, n = 0;
//        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}

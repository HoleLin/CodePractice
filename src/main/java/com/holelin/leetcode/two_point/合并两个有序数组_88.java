package com.holelin.leetcode.two_point;

import java.util.Arrays;

public class 合并两个有序数组_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);

    }

    public static void main(String[] args) {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        final int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        final int[] nums2 = {1, 2, 2};
        merge(nums1, 6, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

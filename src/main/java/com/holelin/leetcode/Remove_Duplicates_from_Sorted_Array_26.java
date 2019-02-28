package com.holelin.leetcode;

/**
 * ClassName: Remove_Duplicates_from_Sorted_Array_26
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/27
 */

public class Remove_Duplicates_from_Sorted_Array_26 {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}
		return j+1;
	}


	public static void main(String[] args) {
		int[] nums1 = {1, 1, 2};
		int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int len1 = removeDuplicates(nums1);
		int len2 = removeDuplicates(nums2);
		System.out.println(len1);
		System.out.println(len2);
	}
}

package com.holelin.leetcode.array;

/**
 * ClassName: Remove_Element_27
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/3/3
 */

public class Remove_Element_27 {
    public static int removeElement(int[] nums, int val) {
        int i;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }

    /**
     * 快慢指针
     * exmple: nums = [3, 2, 2, 3],  val = 3
     *       fastIndex=0,slowIndex=0
     *       fastIndex=1,slowIndex=1
     *       fastIndex=2,slowIndex=2
     *       fastIndex=3,slowIndex=2
     *       last slowIndex=2
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex <= nums.length - 1; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement2(nums1, 3));
        System.out.println(removeElement2(nums2, 2));

    }
}

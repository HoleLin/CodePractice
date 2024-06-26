package com.holelin.leetcode.array;

import java.util.Arrays;

/**
 * ClassName: 977.Squares_of_a_Sorted_Array_977
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/20
 */

public class Squares_of_a_Sorted_Array_977 {
    /**
     * 解决思路: 复制原数组,将数组中元素求绝对值,在求平方,继而排序
     *
     * @param A 原数组
     * @return 处理完的数组
     */
    public static int[] sortedSquares(int[] A) {
        int[] res = Arrays.copyOf(A, A.length);

        for (int i = 0; i < res.length; i++) {
            res[i] = (int) Math.pow(Math.abs(res[i]), 2);
        }
        Arrays.sort(res);
        return res;
    }

    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = result.length - 1;
        while (left <= right) {
            final int leftValue = (int) Math.pow(nums[left], 2);
            final int rightValue = (int) Math.pow(nums[right], 2);
            if (leftValue > rightValue) {
                // 表示平方后最小值变为了最大值
                // 新的最大值填充到结果集中
                result[index--] = leftValue;
                // 向左移动,用下一个值和老的最大值比较
                left++;
            } else {
                // 表示老的最大值还是最大的数
                result[index--] = rightValue;
                //向右移动
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares2(nums1)));

        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares2(nums2)));

    }

}

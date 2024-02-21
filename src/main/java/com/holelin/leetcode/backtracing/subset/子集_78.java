package com.holelin.leetcode.backtracing.subset;

import java.util.LinkedList;
import java.util.List;

public class 子集_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracing(result, path, nums, 0);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                                    int[] nums, int startIndex) {
        result.add(new LinkedList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            final int num = nums[i];
            path.addLast(num);
            backtracing(result, path, nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        final List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}

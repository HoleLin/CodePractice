package com.holelin.leetcode.backtracing.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集II_90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        final LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        final boolean[] used = new boolean[nums.length];
        backtracing(result, path, nums, 0, used);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                                    int[] nums, int startIndex, boolean[] used) {
        result.add(new LinkedList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtracing(result, path, nums, i + 1, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}

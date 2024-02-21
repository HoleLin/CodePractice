package com.holelin.leetcode.backtracing.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列II_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        final boolean[] used = new boolean[nums.length];
        backtracing(result, path, nums, used);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                                    int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == false) {
                path.addLast(nums[i]);
                used[i] = true;
                backtracing(result, path, nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}

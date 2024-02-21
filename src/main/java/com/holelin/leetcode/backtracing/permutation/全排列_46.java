package com.holelin.leetcode.backtracing.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列_46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
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
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtracing(result, path, nums, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,2}));
    }
}

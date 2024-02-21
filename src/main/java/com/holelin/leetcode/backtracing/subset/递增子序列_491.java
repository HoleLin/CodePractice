package com.holelin.leetcode.backtracing.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 递增子序列_491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backtracing(result, path, nums, 0);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, Stack<Integer> path,
                                    int[] nums, int startIndex) {
        // 保持元素个数大于2
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        int[] used = new int[201];

        for (int i = startIndex; i < nums.length; i++) {
            // 保持路径上的元素是递增的
            if (!path.isEmpty() && path.peek() > nums[i] || used[nums[i] + 100] == 1) {
                continue;
            }
            path.push(nums[i]);
            used[nums[i] + 100] = 1;
            backtracing(result, path, nums, i + 1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
    }
}

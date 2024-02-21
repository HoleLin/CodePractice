package com.holelin.leetcode.backtracing.combinesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        // 先进行排序
        Arrays.sort(candidates);
        backtracing(result, path, candidates, target, 0, 0);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                                    int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            final int candidate = candidates[i];
            path.push(candidate);
            sum += candidate;
            backtracing(result, path, candidates, target, sum, i);
            // 回溯
            sum -= candidate;
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

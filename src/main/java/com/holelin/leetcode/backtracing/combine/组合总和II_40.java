package com.holelin.leetcode.backtracing.combine;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和II_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        final boolean[] used = new boolean[candidates.length];
        backtracing(result, path, candidates, target, 0, 0, used);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                                    int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        // 确定递归终止条件
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        // 单层搜索逻辑
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            final int candidate = candidates[i];
            // 去重逻辑,经过排序后的candidates,元素相同则会相邻,若相邻元素相同且当前元素的前一个元素已经被使用过了,则当前元素则无需使用
            // 如果candidates[i] == candidates[i - 1] 并且 used[i - 1] == false，就说明：前一个树枝，使用了candidates[i - 1]，也就是说同一树层使用过candidates[i - 1]。
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            sum += candidate;
            path.push(candidate);
            backtracing(result, path, candidates, target, sum, i + 1, used);
            used[i] = false;
            sum -= candidate;
            path.poll();
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        final List<List<Integer>> lists = combinationSum2(candidates, 8);
        lists.forEach(System.out::println);
    }

}

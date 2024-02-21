package com.holelin.leetcode.backtracing.combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class 组合总和III_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracing(result, path, n, k, 1, 0);
        return result;
    }

    private static void backtracing(List<List<Integer>> result, LinkedList<Integer> path, int n,
                                    int k, int startIndex, int sum) {

        // 剪枝
        if (sum > n) {
            return;
        }

        // 终止条件
        if (path.size() == k) {
            if (sum == n) {
                // 存放结果
                result.add(new ArrayList<>(path));
                return;
            }
        }
        // for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            // 处理节点
            path.push(i);
            sum += i;
            backtracing(result, path, n, k, i + 1, sum);
            // 回溯
            sum -= i;
            path.pop();
        }
    }

    public static void main(String[] args) {
        final List<List<Integer>> lists = combinationSum3(9, 45);
        lists.forEach(System.out::println);
    }
}

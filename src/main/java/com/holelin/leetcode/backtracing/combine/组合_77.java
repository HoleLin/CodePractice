package com.holelin.leetcode.backtracing.combine;

import java.util.LinkedList;
import java.util.List;

public class 组合_77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracing(result, path, n, k, 1);
        return result;
    }


    static void backtracing(List<List<Integer>> result, LinkedList<Integer> path,
                            int n, int k, int startIndex) {
        // 若单个结果的长度与要求收集的数字数量相同,则停止收集
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        // 从startIndex开始遍历,到n
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);

            backtracing(result, path, n, k, i + 1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        final List<List<Integer>> combine = combine(4, 4);
        for (List<Integer> item : combine) {
            System.out.println(item);
        }
    }
}

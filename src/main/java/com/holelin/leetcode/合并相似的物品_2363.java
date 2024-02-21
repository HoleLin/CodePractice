package com.holelin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class 合并相似的物品_2363 {
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(k);
            pair.add(v);
            res.add(pair);
        }
        res.sort(Comparator.comparingInt(a -> a.get(0)));
        return res;
    }

    public static void main(String[] args) {
        final int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        final int[][] items2 = {{3, 1}, {1, 5}};
        System.out.println(mergeSimilarItems(items1, items2));
    }
}

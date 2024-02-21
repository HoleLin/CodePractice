package com.holelin.leetcode.tree.bfs;

import com.holelin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 在每个树行中找最大值_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                final TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            list.add(tempList);
        }
        for (List<Integer> item : list) {
            int max = Integer.MIN_VALUE;
            for (Integer integer : item) {
                max = Math.max(max, integer);
            }
            result.add(max);
        }
        return result;
    }
}

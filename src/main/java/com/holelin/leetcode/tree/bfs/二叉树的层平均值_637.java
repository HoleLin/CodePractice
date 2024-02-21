package com.holelin.leetcode.tree.bfs;

import com.holelin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        final ArrayList<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> templist = new ArrayList<>();
            while (size > 0) {
                final TreeNode node = queue.poll();
                templist.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            list.add(templist);
        }
        for (List<Integer> item : list) {
            double sum = 0;
            for (Integer integer : item) {
                sum += integer;
            }
            result.add(sum / item.size());
        }
        return result;
    }
}

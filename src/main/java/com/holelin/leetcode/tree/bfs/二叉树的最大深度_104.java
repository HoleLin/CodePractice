package com.holelin.leetcode.tree.bfs;

import com.holelin.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度_104 {
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左右中
        final int leftHeight = getHeight(node.left);
        final int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                len--;
            }
            depth++;
        }
        return depth;
    }
}

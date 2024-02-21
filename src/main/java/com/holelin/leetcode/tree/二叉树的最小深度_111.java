package com.holelin.leetcode.tree;

import com.holelin.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return depth;
    }

    public int minDepth2(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左右中
        final int leftHeight = getHeight(node.left);
        final int rightHeight = getHeight(node.right);
        if (node.left == null && node.right != null) {
            return 1 + rightHeight;
        }
        if (node.left != null && node.right == null) {
            return 1 + leftHeight;
        }
        return 1 + Math.min(leftHeight, rightHeight);
    }


}

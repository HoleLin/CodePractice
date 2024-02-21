package com.holelin.leetcode.tree;

import com.holelin.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 对称二叉树_101 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            final TreeNode left = queue.poll();
            final TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            // 处理外侧
            queue.offer(left.left);
            queue.offer(right.right);

            // 处理内侧
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}

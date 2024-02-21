package com.holelin.leetcode.tree.dfs;

import com.holelin.TreeNode;

import java.util.Stack;

public class 翻转二叉树_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历  中 左 右
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        helper(root);
        return root;
    }

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        final TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        helper(node.left);
        helper(node.right);
    }

    void helper2(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        helper(node.right);
        final TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
    }
}

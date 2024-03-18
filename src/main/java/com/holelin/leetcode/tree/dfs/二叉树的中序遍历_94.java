package com.holelin.leetcode.tree.dfs;

import com.holelin.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        final ArrayList<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 中 左 右
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(root.right);
            }
            if (node.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    // 后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        final ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        final Stack<TreeNode> stack = new Stack<>();
        // 左 右 中 ==>  中 右 左 翻转
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        // 中左右
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）

                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）

                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }


    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}

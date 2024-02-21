package com.holelin.leetcode.tree.bfs;

import com.holelin.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> templist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    templist.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    templist.add(node.right.val);
                    queue.offer(node.right);
                }
            }
            result.add(templist);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            result.add(itemList);
        }
        return result;
    }
}

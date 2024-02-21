package com.holelin.leetcode.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> tempList = new ArrayList<>();

            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                tempList.add(node);
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
        for (final List<Node> nodes : list) {
            for (int j = 0; j < nodes.size(); j++) {
                final Node node = nodes.get(j);
                // 非边界
                if (j + 1 < nodes.size()) {
                    node.next = nodes.get(j + 1);
                }
                // 边界
                if (j == nodes.size() - 1) {
                    node.next = null;
                }
            }
        }
        return root;
    }
}

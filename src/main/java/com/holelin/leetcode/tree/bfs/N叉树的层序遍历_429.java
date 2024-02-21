package com.holelin.leetcode.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class N叉树的层序遍历_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            final List<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                final Node node = queue.poll();
                tempList.add(node.val);
                final List<Node> children = node.children;
                if (!children.isEmpty()) {
                    for (Node child : children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
                size--;
            }
            result.add(tempList);
        }
        return result;

    }

}

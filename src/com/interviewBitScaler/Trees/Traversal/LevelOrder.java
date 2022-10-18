package com.interviewBitScaler.Trees.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> out = new ArrayList<>();

        if (root == null) return out;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            out.add(list);
        }
        return out;

    }

    static class TreeNode {
        int val;
        LevelOrder.TreeNode left;
        LevelOrder.TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }
}
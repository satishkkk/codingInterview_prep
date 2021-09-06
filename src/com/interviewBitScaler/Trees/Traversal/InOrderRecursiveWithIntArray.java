package com.interviewBitScaler.Trees.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOrderRecursiveWithIntArray {
    public static void main(String[] args) {
        /*
         *        1
         *      /   \
         *     2     3
         *    / \   /  \
         *   4   5  6   7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] out = inorderTraversal(root);
        Arrays.stream(out).forEach(System.out::println);
    }

    static List<Integer> list = new ArrayList<>();

    public static int[] inorderTraversal(TreeNode A) {
        inorderTraversal(A,list);
        return list.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
    }

    public static void inorderTraversal(TreeNode A , List<Integer> list) {
        if(A == null) return;
        inorderTraversal(A.left,list);
        list.add(A.val);
        inorderTraversal(A.right,list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }
}

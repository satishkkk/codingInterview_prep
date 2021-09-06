package com.interviewBitScaler.Trees.Traversal;

public class TreetraversalRecursion {
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
        System.out.println("IN ORDER TREE TRAVERSAL");
        inorderTraversal(root);
        System.out.println("PRE ORDER TREE TRAVERSAL");
        preorderTraversal(root);
        System.out.println("POST ORDER TREE TRAVERSAL");
        postorderTraversal(root);
    }

    public static void inorderTraversal(TreeNode A) {
        if(A == null) return;
        inorderTraversal(A.left);
        System.out.println(A.val);
        inorderTraversal(A.right);
    }


    public static void preorderTraversal(TreeNode A) {
        if(A == null) return;
        System.out.println(A.val);
        preorderTraversal(A.left);
        preorderTraversal(A.right);
    }


    public static void postorderTraversal(TreeNode A) {
        if(A == null) return;
        postorderTraversal(A.left);
        postorderTraversal(A.right);
        System.out.println(A.val);
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

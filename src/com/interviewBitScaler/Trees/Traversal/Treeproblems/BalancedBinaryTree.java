package com.interviewBitScaler.Trees.Traversal.Treeproblems;

import java.util.Arrays;

public class BalancedBinaryTree {


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
        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);
        System.out.println(isBalanced(root));
    }

    public static int isBalanced(TreeNode A) {
        return isBalancedTree(A) ? 1:0;
    }


    public static boolean isBalancedTree(TreeNode A) {
        if(A==null) return true;

        int lh = getHeight(A.left);
        int rh = getHeight(A.right);

        return (Math.abs(lh-rh) <=1) && isBalancedTree(A.left) && isBalancedTree(A.right);
    }

    public static int getHeight(TreeNode A){
        if(A == null) return 0;
        return Math.max(getHeight(A.left),getHeight(A.right))+1;
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

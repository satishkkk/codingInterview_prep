package com.interviewBitScaler.Trees.Traversal.Treeproblems;

public class LeftNodeSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }

    public static void main(String[] args) {

        /*
         *        1
         *      /   \
         *     2     3
         *    / \   /  \
         *   4   5  6   7
         */
        TreeNode root = new LeftNodeSum.TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        root.right.right.right = new TreeNode(8);
//        root.right.right.right.right = new TreeNode(9);
        System.out.println(getLeftSumTree(root));
    }

    static int sum=0;
    public static int getLeftSumTree( TreeNode root ){

        if(root == null) return 0;

        if(root.left!= null){
            System.out.println(root.left.val);
            sum += root.left.val;
            getLeftSumTree(root.left);
        }
        getLeftSumTree(root.right);

        return sum;
    }

}

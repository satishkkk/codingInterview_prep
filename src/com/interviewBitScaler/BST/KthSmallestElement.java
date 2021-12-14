package com.interviewBitScaler.BST;

import javax.swing.tree.TreeNode;

public class KthSmallestElement {

    static int out =0;
    static int index=0;
    public static void main(String[] args) {
        /*
         *        3
         *      /   \
         *     1     4
         *      \
         *       2
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root,1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        //IN ORDER TREE TRAVERSAL MAINTAIN COUNT
        kthSmallestHelper(root,k);  //3 1 0
        return out;
    }

    public static void  kthSmallestHelper(TreeNode root, int k){
        if (root==null) return;
        kthSmallestHelper(root.left,k);

        System.out.println();
        index++;
        if(index==k){
            out= root.val;
        }

        kthSmallestHelper(root.right,k);
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

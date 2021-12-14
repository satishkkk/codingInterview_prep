package com.interviewBitScaler.Trees.Traversal.Treeproblems;

import java.util.ArrayList;



public class HeightOfTree {

    static class TreeNode {
        int val;
        HeightOfTree.TreeNode left;
        HeightOfTree.TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }

    static int diameter;

    public static void main(String[] args) {
        /*
         *        1
         *      /   \
         *     2     3
         *    / \   /  \
         *   4   5  6   7
         */
        HeightOfTree.TreeNode root = new HeightOfTree.TreeNode(1);
        root.left = new HeightOfTree.TreeNode(2);
        root.right = new HeightOfTree.TreeNode(3);
        root.left.left = new HeightOfTree.TreeNode(4);
        root.left.right = new HeightOfTree.TreeNode(5);
        root.right.left = new HeightOfTree.TreeNode(6);
        root.right.right = new HeightOfTree.TreeNode(7);
//        root.right.right.right = new HeightOfTree.TreeNode(8);
//        root.right.right.right.right = new HeightOfTree.TreeNode(9);
        System.out.println(getHeight(root));
        getDiameter(root);
        System.out.println("Diameter :"+ diameter);

    }

    public static int getHeight(HeightOfTree.TreeNode node){
        if(node == null) return 0;
        int left =getHeight(node.left);
        int right =getHeight(node.right);
        return Math.max(left,right)+1;
    }

    public static int getDiameter(HeightOfTree.TreeNode node){
        if(node == null) return 0;
        int left =getHeight(node.left);
        int right =getHeight(node.right);

        diameter = Math.max(diameter,left+right);

        return Math.max(left,right)+1;
    }
}

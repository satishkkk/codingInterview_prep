package com.interviewBitScaler.Trees.Traversal.Treeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class SerializeBinaryTree {
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
        ArrayList<Integer> list = solve(root);
        list.forEach(System.out::println);
        int[ ] n = new int[10];
        
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(A==null) {
            list.add(-1);
            return list;
        }

        queue.offer(A);
        list.add(A.val);
        while(queue!=null){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.left  != null ) {
                    queue.offer(node.left);
                    list.add(node.left.val);
                }else{
                    list.add(-1);
                }

                if(node.right  != null){
                    queue.offer(node.right);
                    list.add(node.right.val);
                }else{
                    list.add(-1);
                }
            }
        }
        return list;
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

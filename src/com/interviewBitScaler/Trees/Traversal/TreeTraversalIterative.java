package com.interviewBitScaler.Trees.Traversal;

import java.util.*;

public class TreeTraversalIterative {


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


    public static int[] inorderTraversal(TreeNode A) { //LEFT | VISIT | RIGHT
        if(A == null) return new int[]{};

        List<Integer> list = new ArrayList<Integer>();
        TreeNode root =A;
        Stack<TreeNode> stack = new Stack<>();

        while(root!= null || !stack.isEmpty()){
            if(root!=null){//iterate to until left
                stack.push(root);
                root=root.left;
            }else{ // traverse on right node
                root = stack.peek();
                list.add(root.val); //visit node
                stack.pop();
                root=root.right; // traverse right
            }
        }
        return list.stream().mapToInt(t->t).toArray();
    }

    public int[] preorderTraversal(TreeNode A) { // VISIT | LEFT | RIGHT
        if(A == null) return new int[]{};

        List<Integer> list = new ArrayList<Integer>();
        TreeNode root =A;
        Stack<TreeNode> stack = new Stack<>();

        while(root!= null || !stack.isEmpty()){
            if(root!=null){
                list.add(root.val);//visit node
                stack.push(root);
                root=root.left;//iterate to until left
            }else{// traverse on right node
                root = stack.peek();
                stack.pop();
                root=root.right;
            }
        }
        return list.stream().mapToInt(t->t).toArray();
    }

    // PRE ORDER : VISIT LEFT RIGHT
    //POST ORDER : LEFT RIGHT VISIT
    // APPROCH = REVERSE(VISIT RIGHT LEFT) => LEFT RIGHT VISIT
    public int[] postorderTraversal(TreeNode A) {
        if(A == null) return new int[]{};

        List<Integer> list = new ArrayList<Integer>();
        TreeNode root =A;
        Stack<TreeNode> stack = new Stack<>();

        while(root!= null || !stack.isEmpty()){
            if(root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.right;
            }else{
                root = stack.peek();
                stack.pop();
                root=root.left;
            }
        }
        Collections.reverse(list);
        return list.stream().mapToInt(t->t).toArray();

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

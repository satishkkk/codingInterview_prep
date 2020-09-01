package com.company.Trees;

class Node{
    int data;
    Node left;
    Node right;
}

class BST{
    public Node createNode(int data){
        Node node= new Node();
        node.data=data;
        node.left=null;
        node.right= null;
        return node;
    }

    public Node insert(Node node,int data){
        if(node == null){
            node =createNode(data);
        }else{
            if(data < node.data )
                node.left=insert(node.left,data);
            else
                node.right=insert(node.right,data);
        }
        return node;
    }
    public Node Delete(int data){
        return null;
    }

    public void inorderTreeTraveral(Node root){
        if(root == null)
            return;
        inorderTreeTraveral(root.left);
        System.out.println(root.data);
        inorderTreeTraveral(root.right);
    }

    public void preorderTreeTraveral(Node root){
        if(root == null)
            return;
        System.out.println(root.data);
        inorderTreeTraveral(root.left);
        inorderTreeTraveral(root.right);
    }

    public void postorderTreeTraveral(Node root){
        if(root == null)
            return;
        inorderTreeTraveral(root.left);
        inorderTreeTraveral(root.right);
        System.out.println(root.data);
    }
}

public class BSTApp {

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;

        root = bst.insert(root,10);
        root = bst.insert(root,5);
        root = bst.insert(root,12);
        root = bst.insert(root,11);
        root = bst.insert(root,7);
        root = bst.insert(root,19);
        System.out.println("INORDER");
        bst.inorderTreeTraveral(root);
        System.out.println("PREORDER");
        bst.preorderTreeTraveral(root);
        System.out.println("POSTORDER");
        bst.postorderTreeTraveral(root);
    }
}

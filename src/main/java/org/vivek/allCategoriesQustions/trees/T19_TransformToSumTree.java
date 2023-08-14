package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class T19_TransformToSumTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preorder(root);
        toSumTree(root);
        System.out.println();
        preorder(root);
    }
    private static void toSumTree(Node root){
       dfs(root);
    }
    private static int dfs(Node root) {
        if(root == null) return 0;
        int val = root.data;
        int ls = dfs(root.left);
        int rs = dfs(root.right);
        root.data = ls+rs;
        return ls+rs+val;
    }
    private static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

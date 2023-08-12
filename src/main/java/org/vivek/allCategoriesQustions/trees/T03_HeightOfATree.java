package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
public class T03_HeightOfATree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int height = height(root);
        System.out.println(height);
    }
    private static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
}

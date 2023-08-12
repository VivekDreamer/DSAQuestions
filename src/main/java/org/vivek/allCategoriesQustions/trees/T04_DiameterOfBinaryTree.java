package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
public class T04_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int diameter = diameter(root);
        System.out.println(diameter);
    }
    public static int diameter(Node root){
        int[] diameter = new int[1];
        diameterUtil(root, diameter);
        return diameter[0];
    }
    public static int diameterUtil(Node root, int[] diameter){
        if(root == null) return 0;
        int lh = diameterUtil(root.left, diameter);
        int rh = diameterUtil(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh+1);
        return Math.max(lh,rh)+1;
    }
}

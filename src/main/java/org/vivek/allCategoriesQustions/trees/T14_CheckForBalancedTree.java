package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class T14_CheckForBalancedTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        boolean isBalanced = isBalanced(root);
        boolean isBalancedTree = isBalancedEfficient(root);
        System.out.println(isBalanced);
        System.out.println(isBalancedTree);
    }

    //naive approach
    private static boolean isBalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) > 1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right) return false;
        return true;
    }
    private static int height(Node node) {
        if(node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }

    //efficient approach
    private static boolean isBalancedEfficient(Node root){
        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(Node root) {
        if(root == null) return 0;
        int lh = dfsHeight(root.left);
        if(lh == -1) return -1;
        int rh = dfsHeight(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh) > 1) return -1;
        return Math.max(lh,rh)+1;
    }
}

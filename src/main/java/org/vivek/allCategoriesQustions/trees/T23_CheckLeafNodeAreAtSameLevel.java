package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
public class T23_CheckLeafNodeAreAtSameLevel {
    static int levelOfLeafNode = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(15);
        boolean check = check(root);
        System.out.println(check);
    }
    private static boolean check(Node root){
        return checkUtil(root,0);
    }
    private static boolean checkUtil(Node root, int level) {
        if(root == null) return true;
        if(root.left == null && root.right == null){
            if(levelOfLeafNode == 0){
                levelOfLeafNode = level;
            }
            return levelOfLeafNode == level;
        }
        return checkUtil(root.left, level+1) && checkUtil(root.right, level+1);
    }
    
}

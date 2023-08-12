package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/mirror-tree/1
public class T05_MirrorTreeFromGivenBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        mirror(root);
    }
    private static void mirror(Node node){
        //go to the last node in the left and right node
        //simply reverse the left and right node
        if(node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1
public class POTD_FlatternBSTToSortedList {
    Node prev;
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.right);
        root.right = prev;
        prev = root;
        inorder(root.left);
        root.left = null;
    }
    public Node flattenBST(Node root) {
        inorder(root);
        return prev;
    }
}
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right  = null;
    }
}

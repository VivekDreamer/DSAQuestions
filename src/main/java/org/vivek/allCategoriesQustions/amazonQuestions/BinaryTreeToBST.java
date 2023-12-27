package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
public class BinaryTreeToBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int _data){
            this.data = _data;
            this.left = null;
            this.right = null;
        }
    }
    Node binaryTreeToBST(Node root){
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root,inorder);
        Collections.sort(inorder);
        int[] points = new int[]{0};
        inorder_bst(root,inorder,points);
        return root;
    }
    private void inorder_bst(Node root, List<Integer> inorder, int[] points) {
        if(root == null) return;
        inorder_bst(root.left, inorder, points);
        root.data = inorder.get(points[0]);
        points[0]++;
        inorder_bst(root.right, inorder, points);
    }
    private void inorderTraversal(Node root, List<Integer> inorder) {
        if(root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }
    
}

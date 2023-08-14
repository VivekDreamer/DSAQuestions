package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class T16_BoundaryTraversalOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> boundary = boundary(root);
        System.out.println(boundary);
    }

    private static ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(!isLeaf(root)) list.add(root.data);
        addLeftBoundary(root,list);
        addLeaves(root,list);
        addRightBoundary(root,list);
        return list;
	}

    //add the left boundary, except the leaf nodes
    private static void addLeftBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) list.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    //add the leaf node by doing preorder traversal...if it is leaf node then, add it in the list
    private static void addLeaves(Node root, ArrayList<Integer> list) {
        if(isLeaf(root)){
            list.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, list);
        if(root.right != null) addLeaves(root.right, list);
    }

    //add the right boundary in the reverse order, except the leaf nodes
    private static void addRightBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        for(i = temp.size()-1; i >= 0; i--){
            list.add(temp.get(i));
        }
    }

    //check whether the given node is leaf node or not
    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}

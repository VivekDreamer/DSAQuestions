package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class T18_BinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node bToDLL = bToDLL(root);
    }

    private static Node bToDLL(Node root)
    {
        List<Node> inorder = new ArrayList<>();
        fun(root,inorder);
        Node head = inorder.get(0);
        Node travel = head;
        for(int i = 1; i < inorder.size(); i++){
            Node curr = inorder.get(i);
            travel.right = curr;
            curr.left = travel;
            travel = curr;
        }
        return head;
    }

    private static void fun(Node root, List<Node> inorder) {
        if(root == null) return;
        fun(root.left,inorder);
        inorder.add(root);
        fun(root.right, inorder);
    }
}

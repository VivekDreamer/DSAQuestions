package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class T06_InorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> inorderTraversal = inorderTraversal(root);
        List<Integer> inorderIterative = inorderIterative(root);
        System.out.println(inorderTraversal);
        System.out.println(inorderIterative);
    }

    //recursive approach
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;
        inorderTraversalUtil(root,inorder);
        return inorder;
    }
    public static void inorderTraversalUtil(Node root, List<Integer> inorder){
        if(root == null) return;
        inorderTraversalUtil(root.left, inorder);
        inorder.add(root.data);
        inorderTraversalUtil(root.right, inorder);
    }

    //iterative approach
    public static List<Integer> inorderIterative(Node root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();   
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }
}

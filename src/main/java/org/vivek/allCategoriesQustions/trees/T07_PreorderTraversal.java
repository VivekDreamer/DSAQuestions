package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T07_PreorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> preorderTraversal = preorderTraversal(root);
        List<Integer> preorderIterative = preorderIterative(root);
        System.out.println(preorderTraversal);
        System.out.println(preorderIterative);
    }

    //recursive approach
    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        preorderTraversalUtil(root,preorder);
        return preorder;
    }
    public static void preorderTraversalUtil(Node root, List<Integer> preorder){
        if(root == null) return;
        preorder.add(root.data);
        preorderTraversalUtil(root.left, preorder);
        preorderTraversalUtil(root.right, preorder);
    }

    //iterative approach
    public static List<Integer> preorderIterative(Node root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            preorder.add(node.data);
        }
        return preorder;
    }
}

package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class T08_PostorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> postorderTraversal = postorderTraversal(root);
        List<Integer> postorderIterative = postorderIterative(root);
        System.out.println(postorderTraversal);
        System.out.println(postorderIterative);
    }

    //recursive approach
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> postorder = new ArrayList<>();
        if(root == null) return postorder;
        postorderTraversalUtil(root,postorder);
        return postorder;
    }
    private static void postorderTraversalUtil(Node root, List<Integer> postorder) {
        if(root == null) return;
        postorderTraversalUtil(root.left,postorder);
        postorderTraversalUtil(root.right, postorder);
        postorder.add(root.data);
    }

    // iterative approach
    public static List<Integer> postorderIterative(Node root){
        List<Integer> postorder = new ArrayList<>();
        if(root == null) return postorder;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }
        while(!stack2.isEmpty()){
            Node node = stack2.pop();
            postorder.add(node.data);
        }
        return postorder;
    } 
}

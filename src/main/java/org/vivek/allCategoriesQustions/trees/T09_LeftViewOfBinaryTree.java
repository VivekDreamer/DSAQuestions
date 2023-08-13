package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class T09_LeftViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> leftView = leftView(root);
        ArrayList<Integer> leftViewIterative = leftViewIterative(root);
        System.out.println(leftView);
        System.out.println(leftViewIterative);
    }

    //recursive
    public static ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> leftView = new ArrayList<>();
        leftViewUtil(root,leftView,0);
        return leftView;
    }
    private static void leftViewUtil(Node root, ArrayList<Integer> leftView, int currDepth) {
        if(root == null) return;
        if(leftView.size() == currDepth)
            leftView.add(root.data);
        leftViewUtil(root.left, leftView, currDepth+1);
        leftViewUtil(root.right, leftView, currDepth+1);
    }

    //iterative
    private static ArrayList<Integer> leftViewIterative(Node root){
        ArrayList<Integer> leftView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return leftView;
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                Node node = queue.poll();
                if(i == 0) leftView.add(node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return leftView;
    }
}

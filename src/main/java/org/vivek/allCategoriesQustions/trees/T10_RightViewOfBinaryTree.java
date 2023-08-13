package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/submissions/925794360/
public class T10_RightViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> rightSideView = rightSideView(root);
        List<Integer> rightSideIterative = rightSideIterative(root);
        System.out.println(rightSideView);
        System.out.println(rightSideIterative);
    }

    //recursive
    public static List<Integer> rightSideView(Node root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null) return rightSide;
        rightSideViewUtil(root,rightSide,0);
        return rightSide;
    }
    private static void rightSideViewUtil(Node root, List<Integer> rightSide, int currDepth) {
        if(root == null) return;
        if(rightSide.size() == currDepth) rightSide.add(root.data);
        rightSideViewUtil(root.right, rightSide, currDepth+1);
        rightSideViewUtil(root.left, rightSide, currDepth+1);
    }

    //iterative
    public static List<Integer> rightSideIterative(Node root){
        List<Integer> rightSide = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return rightSide;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i == size-1) rightSide.add(node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return rightSide;
    }
}

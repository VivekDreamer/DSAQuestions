package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class T15_DiagonalTraversalOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> diagonal = diagonal(root);
        System.out.println(diagonal);
    }

    public static ArrayList<Integer> diagonal(Node root){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node node = queue.poll();
                while(node != null){
                    list.add(node.data);
                    if(node.left != null) queue.add(node.left);
                    node = node.right;
                }
            }
        }
        return list;
    }
}

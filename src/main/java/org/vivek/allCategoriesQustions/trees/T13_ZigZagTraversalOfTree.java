package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class T13_ZigZagTraversalOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> zigZagTraversal = zigZagTraversal(root);
        System.out.println(zigZagTraversal);
    }
    
    private static ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer> zigzagList = new ArrayList<>();
        if(root == null) return zigzagList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sizeOfList = zigzagList.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(flag == false) zigzagList.add(node.data);
                else zigzagList.add(sizeOfList, node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            flag = !flag;
        }
        return zigzagList;
	}
}

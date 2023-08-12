package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
public class T02_ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> reverseLevelOrder = reverseLevelOrder(root);
        System.out.println(reverseLevelOrder);
    }
    private static ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(node == null) return ans;
        queue.offer(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right != null) queue.add(temp.right);
            if(temp.left != null) queue.add(temp.left);
            ans.add(temp.data);
        }
        Collections.reverse(ans);
        return ans;
    }
}

package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
public class SerializeAndDeserializeABinaryTree {
    
    public void serialize(Node root, ArrayList<Integer> arr){
        if(root == null){
            arr.add(-1);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node == null){
                arr.add(-1);
                continue;
            }
            arr.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public Node deserialize(ArrayList<Integer> arr){
        if(arr.size() == 0) return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr.get(0));
        queue.add(root);
        int i = 1;
        while(i < arr.size()){
            Node parent = queue.poll();
            if(arr.get(i) != -1){
                Node left = new Node(arr.get(i));
                parent.left = left;
                queue.add(left);
            }
            if(arr.get(++i) != -1){
                Node right = new Node(arr.get(i));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

package org.vivek.allCategoriesQustions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class POTD_BinaryTreeToCDLL {
    Queue<Node> queue = new LinkedList<>();
    Node bTreeToClist(Node root){
        traverse(root);
        Node node = queue.poll();
        root = node;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            node.right = temp;
            temp.left = node;
            node = temp;
            if(queue.isEmpty()){
                temp.right = root;
                root.left = temp;
            }
        }
        return root;
    }
    void traverse(Node root){
        if(root == null) return;
        traverse(root.left);
        queue.add(root);
        traverse(root.right);
    }
}

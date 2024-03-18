package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/level-order-traversal/1
public class POTD_LevelOrderTraversal {
    static ArrayList <Integer> levelOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.peek();
            queue.poll();
            arr.add(node.data);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return arr;
    }
}

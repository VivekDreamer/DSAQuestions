package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

// Print a binary tree in a vertical order
public class VerticalTraversalOfBinaryTree {
    
    static ArrayList<Integer> getVerticalTraversalOfBinaryTree(Node root){
        if(root == null) return new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.peek();
            Node node = tuple.node;
            int level = tuple.level;
            int vertical = tuple.vertical;
            queue.poll();

            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new ArrayList<>());
            }

            map.get(vertical).get(level).add(node.data);

            if(node.left != null){
                queue.add(new Tuple(node.left, level+1, vertical-1));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right, level+1, vertical+1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(TreeMap<Integer,ArrayList<Integer>> ys : map.values()){
            for(ArrayList<Integer> list : ys.values()){
                for(int num : list){
                    ans.add(num);
                }
            }
        }

        return ans;
    }

    static class Tuple{
        Node node;
        int level;
        int vertical;
        Tuple(Node _node, int _level, int _vertical){
            this.node = _node;
            this.level = _level;
            this.vertical = _vertical;
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int _data, Node _left, Node _right){
            this.data = _data;
            this.left = _left;
            this.right = _right;
        }
    }
}

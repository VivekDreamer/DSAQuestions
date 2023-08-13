package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class T12_BottomViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> bottomView = bottomView(root);
        System.out.println(bottomView);
    }

    public static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> bottomView = new ArrayList<>();
        if(root == null) return bottomView;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int hd = pair.hd;
            Node node = pair.node;
            map.put(hd, node.data);
            if(node.left != null) queue.add(new Pair(hd-1,node.left));
            if(node.right != null) queue.add(new Pair(hd+1, node.right));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            bottomView.add(entry.getValue());
        }
        return bottomView;
    }

    static class Pair{
        int hd;
        Node node;
        Pair(int _hd, Node _node){
            this.hd = _hd;
            this.node = _node;
        }
    }
}

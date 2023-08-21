package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-subtrees/description/
// https://practice.geeksforgeeks.org/problems/duplicate-subtrees/1
public class T34_findDuplicateSubtrees {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        List<Node> list = findDuplicateSubtrees(root);
        System.out.println(list);
    }

    private static List<Node> findDuplicateSubtrees(Node root) {
        Map<String,Integer> map = new HashMap<>();
        List<Node> res = new ArrayList<>();
        findDuplicateSubtreesUtil(root,map,res);
        return res;
    }

    private static String findDuplicateSubtreesUtil(Node root, Map<String, Integer> map, List<Node> res) {
        if(root == null) return "N";
        String s = root.data+ "," + findDuplicateSubtreesUtil(root.left, map, res) + "," + findDuplicateSubtreesUtil(root.right, map, res);
        if(map.containsKey(s) && map.get(s) == 1){
            res.add(root);
        }
        map.put(s, map.getOrDefault(s,0)+1);
        //for sorting list lexicographically
        Collections.sort(res,(a,b)->a.data-b.data);
        return s;
    }
}

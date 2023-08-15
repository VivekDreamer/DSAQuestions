package org.vivek.allCategoriesQustions.trees;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
public class T24_FindDuplicateeSubtrees {
    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.right = new Node(2);
        // root.right.right.left = new Node(4);
        // root.right.right.right = new Node(5);
        Node root = new Node(68);
        root.left = new Node(23);
        root.right = new Node(36);
        root.left.left = new Node(49);
        root.left.right = new Node(57);
        root.right.left = new Node(23);
        root.right.left.left = new Node(49);
        root.right.left.right = new Node(57);
        int dupSub = dupSub(root);
        int dupSub2 = dupSub2(root);
        System.out.println(dupSub);
        System.out.println(dupSub2);
    }
   
    private static int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<>();
        dupSubUtil(root,map);
        int ans = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() >= 2 && entry.getKey().split(",").length != 3) ans++;
        }
        return ans;
    }
    private static String dupSubUtil(Node root, Map<String, Integer> map) {
        if(root == null) return "N";
        String s = root.data + "," + dupSubUtil(root.left,map) + "," + dupSubUtil(root.right,map);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }

    //second way but it is very similar to above
    private static int dupSub2(Node root) {
        Map<String, Integer> map = new HashMap<>();
        dupSubUtil2(root,map);
        int ans = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() >= 2) ans++;
        }
        return ans;
    }

    private static String dupSubUtil2(Node root,Map<String, Integer> map){
        if(root == null)
            return "$";
        String s = "";
        if(root.left == null && root.right == null){
            s+=root.data;
            return s;
        }
        s=s+root.data+"@"+dupSubUtil2(root.left,map)+"@"+dupSubUtil2(root.right,map);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }
}

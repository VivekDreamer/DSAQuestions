package org.vivek.allCategoriesQustions.trees;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
public class T29_MaximumSumOfNonAdjacentNodes {
    static Map<Node,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        int maxSum = getMaxSum(root);
        System.out.println(maxSum);
    }

    private static int getMaxSum(Node root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int includeSum = 0;
        if(root.left != null){
            includeSum += getMaxSum(root.left.left);
            includeSum += getMaxSum(root.left.right);
        }
        if(root.right != null){
            includeSum += getMaxSum(root.right.left);
            includeSum += getMaxSum(root.right.right);
        }
        includeSum += root.data;
        int excludeSum = getMaxSum(root.left) + getMaxSum(root.right);
        int ans = Math.max(includeSum, excludeSum);
        map.put(root, ans);
        return ans;
    }
    

}

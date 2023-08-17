package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/largest-subtree-sum-in-a-tree/1
public class T28_LongestSubtreeSumInATree {
    int maxSum = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(-4);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(6);
        T28_LongestSubtreeSumInATree t = new T28_LongestSubtreeSumInATree();
        int sum = t.findLargestSubtreeSum(root); 
        int sum2 = t.findLargestSubtreeSum2(root);
        System.out.println(sum);
        System.out.println(sum2);
    }
    private int findLargestSubtreeSum(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int num = sum(root);
        return maxSum; 
    }
    private int sum(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sumRootToNode = root.data + leftSum + rightSum;
        int tempMax = Math.max(sumRootToNode, Math.max(leftSum, rightSum));
        maxSum = Math.max(maxSum,tempMax);
        return sumRootToNode;
    }
    private int findLargestSubtreeSum2(Node root){
        findLargestSubtreeSum2Util(root);
        return max;
    }
    private int findLargestSubtreeSum2Util(Node root) {
        if(root == null) return 0;
        int left = findLargestSubtreeSum2Util(root.left);
        int right = findLargestSubtreeSum2Util(root.right);
        max = Math.max(max,root.data+left+right);
        return (root.data+left+right);
    }
    
}

package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
public class T32_DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        int a = 3;
        int b = 6;
        int minDistance = findDist(root,3,6);   
        System.out.println("distance between two nodes "+a+" and "+b+" is "+minDistance);
    }

    private static int findDist(Node root, int a, int b) {
        if(root == null) return 0;
        Node lca = lca(root,a,b);
        int x = solve(lca,a); //distance between lca and a
        int y = solve(lca,b); //distance between lca and b
        return x+y-2;
    }

    private static Node lca(Node root, int a, int b) {
        if(root == null || root.data == a || root.data == b) return root;
        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }

    private static int solve(Node lca, int val) {
        if(lca == null) return 0;
        if(lca.data == val) return 1;
        int a = solve(lca.left, val);
        int b = solve(lca.right, val);
        if(a == 0 && b == 0) return 0;
        return a+b+1;
    }
}

package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
public class T35_TreeIsIsomorphismOrNot {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);
        root1.right.left = new Node(6);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.left.right = new Node(6);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);

        boolean isomorphic = isIsomorphic(root1, root2);
        System.out.println(isomorphic);


    }
    private static boolean isIsomorphic(Node root1, Node root2)  
    { 
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;
        boolean a = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        boolean b = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
        return a||b;
    }
}

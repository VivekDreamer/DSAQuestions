package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://geeksforgeeks.org/problems/closest-neighbor-in-bst/1
public class POTD_ClosestNeighbourInBST {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        if (root == null)
            return -1;
            
        if (root.key > n)
            return findMaxForN(root.left, n);
        
        int rightkey = findMaxForN(root.right, n);
        return root.key > rightkey ? root.key : rightkey;
    }
    static class Node
    {
        int key;
        Node left, right;
        Node(int x){
            key = x;
            left = right = null;
        }
}
}

package org.vivek.allCategoriesQustions.trees;

public class POTD_SymmetricTree {
    public static boolean isSymmetric(Node root){
        if(root == null) return true;
        return isSymmetricUtil(root.left, root.right);
    }
    public static boolean isSymmetricUtil(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.data != root2.data) return false;
        boolean left = isSymmetricUtil(root1.left, root2.right);
        boolean right = isSymmetricUtil(root1.right, root2.left);
        return left && right;
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
}

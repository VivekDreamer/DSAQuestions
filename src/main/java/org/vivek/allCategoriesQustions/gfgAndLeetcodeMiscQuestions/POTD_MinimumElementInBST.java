package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

public class POTD_MinimumElementInBST {
    int minValue(Node root) {
        if(root == null)return -1;
        if(root.left == null)return root.data;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/leaf-at-same-level/1
public class POTD_CheckIfAllLeavesAreAtSameLevel {
    int levelOfLeafNode = 0;
    boolean check(Node root){
	    return checkUtil(root,0);
    }
    boolean checkUtil(Node root, int level){
        if(root == null) return true;
        if(root.left == null && root.right == null){
            if(levelOfLeafNode == 0){
                levelOfLeafNode = level;
            }
            return level == levelOfLeafNode;
        }
        return checkUtil(root.left, level + 1) && checkUtil(root.right, level + 1);
    }
    static class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}

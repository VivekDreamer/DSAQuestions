package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/sum-of-leaf-nodes-in-bst/1
public class POTD_SumOfLeafNodes {
    public static int sumOfLeafNodes(Node root){
        return root==null?0: (root.left == null && root.right == null)?root.data : sumOfLeafNodes(root.left)+sumOfLeafNodes(root.right);
    }
}

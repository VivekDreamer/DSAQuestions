package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/construct-tree-1/1
public class T20_ConstructBinaryTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        int inorder[] = {7, 3, 11, 1, 17, 3, 18};
        int preorder[] = {1, 3, 7, 11, 3, 17, 18};
        int n = 7;
        Node root = buildTree(inorder, preorder, n);
    }
    private static Node buildTree(int inorder[], int preorder[], int n){
        Node root = buildTreeUtil(preorder,0,n-1,inorder,0,n-1);
        return root;
    }
    private static Node buildTreeUtil(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend || instart > inend) return null;
        Node root = new Node(preorder[prestart]);
        int inRoot = -1;
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == root.data){
                inRoot = i;
                break;
            }
        }
        if(inRoot == -1) return null;
        int numsLeft = inRoot - instart;
        root.left = buildTreeUtil(preorder, prestart+1, prestart+numsLeft, inorder, instart, inRoot-1);
        root.right = buildTreeUtil(preorder, prestart+numsLeft+1, preend, inorder, inRoot+1, inend);
        return root;
    }
}

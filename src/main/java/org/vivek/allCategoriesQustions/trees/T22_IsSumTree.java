package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/sum-tree/1
public class T22_IsSumTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        boolean isSumTree = isSumTree(root);
        boolean sumTree2 = isSumTree2(root);
        boolean sumTree3 = isSumTree3(root);
        System.out.println(isSumTree);
        System.out.println(sumTree2);
        System.out.println(sumTree3);
    }

    private static boolean isSumTree(Node root) {
        int lSum,rSum;
        if(root == null || (root.left == null && root.right == null)) return true;
        lSum = sum(root.left);
        rSum = sum(root.right);
        if(root.data == lSum+rSum && isSumTree(root.left) && isSumTree(root.right)) return true;
        return false;
    }

    private static int sum(Node node) {
        if(node == null) return 0;
        return sum(node.left)+node.data+sum(node.right);
    }

    private static boolean isSumTree2(Node root)
    {
	    return isSumTreeUtil(root);
	}
	private static boolean isLeaf(Node node){
	    if(node.left == null && node.right == null)return true;
	    return false;
	}
	private static boolean isSumTreeUtil(Node root){
	    if(root==null)return true;
	    if(isLeaf(root)){
	        return true;
	    }
	    boolean left=isSumTreeUtil(root.left);
	    boolean right = isSumTreeUtil(root.right);
	    if(!left || !right)return false;
	    int leftSum=root.left!=null?root.left.data:0;
	    int rightSum=root.right!=null?root.right.data:0;
	    if(root.data==leftSum+rightSum){
	        root.data+=(leftSum+rightSum);
	        return true;
	    }
	    return false;
	}

    static boolean f = true;
	private static boolean isSumTree3(Node root){
	    sum3(root);
	    return f;
	}
	private static int sum3(Node root){
	    if(root == null)return 0;
	    if(root.left == null && root.right == null)return root.data;
	    if(f == false)return 0;
	    int leftSum = sum(root.left);
	    int rightSum = sum(root.right);
	    if(leftSum + rightSum != root.data)f=false;
	    return leftSum+rightSum+root.data;
	}

}

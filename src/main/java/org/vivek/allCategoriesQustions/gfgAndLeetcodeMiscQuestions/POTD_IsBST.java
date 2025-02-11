class POTD_IsBST {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        // code here.
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean isBSTUtil(Node root, long minVal, long maxVal){
        if(root == null)return true;
        if(root.data <= minVal || root.data >= maxVal)return false;
        return isBSTUtil(root.left, minVal, root.data)
            && isBSTUtil(root.right, root.data, maxVal);
    }
}

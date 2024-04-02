class POTD_MinimumAbsoluteDifferenceInBST{
    Node node = null;
    int min = Integer.MAX_VALUE;
    int absolute_diff(Node root)
    {
        //Your code here
        absolute_diff_helper(root);
        return min;
    }
    void absolute_diff_helper(Node root){
        if(root == null)
            return;
        absolute_diff_helper(root.left);
        if(node != null)
            min = Math.min(min, Math.abs(root.data-node.data));
        node = root;
        absolute_diff_helper(root.right);
    }
}

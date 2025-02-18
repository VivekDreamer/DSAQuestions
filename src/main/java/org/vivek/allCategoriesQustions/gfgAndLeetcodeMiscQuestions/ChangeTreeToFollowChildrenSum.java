class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class ChangeTreeToFollowChildrenSum {
    public void changeTree(TreeNode root) {
        if(root == null) return;
        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if(root.left != null){
            child += root.left.val;
        }
        if(root.right != null){
            child += root.right.val;
        }
        // Compare the sum of children with
        // the current node's value and update
        if(child >= root.val) root.val = child;
        else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }
        // Recursively call the function
        // on the left and right children.
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        if(root.left != null) total += root.left.val;
        if(root.right != null) total += root.right.val;
        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if(root.left != null || root.right != null) root.val = total;
    }
}

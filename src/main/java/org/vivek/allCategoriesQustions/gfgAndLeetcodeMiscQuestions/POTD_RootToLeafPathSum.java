class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class POTD_RootToLeafPathSum {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int S) {
        int sum = 0;
        return hasPathSumUtil(root,sum,S);
    }
    boolean hasPathSumUtil(Node root, int sum, int targetSum){
        if(root == null) return false;
        sum += root.data;
        if(sum == targetSum && root.left == null && root.right == null) return true;
        if(hasPathSumUtil(root.left, sum, targetSum) || hasPathSumUtil(root.right, sum, targetSum)) return true;
        sum -= root.data;
        return false;
    }
}

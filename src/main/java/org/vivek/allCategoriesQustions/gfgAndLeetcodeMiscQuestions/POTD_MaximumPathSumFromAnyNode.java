// https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class POTD_MaximumPathSumFromAnyNode {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(node,maxValue);
        return maxValue[0];
    }
    public int maxPathDown(Node node, int[] maxValue){
        if(node == null) return 0;
        int left  = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], node.data+left+right);
        return Math.max(left,right) + node.data;
    }
}

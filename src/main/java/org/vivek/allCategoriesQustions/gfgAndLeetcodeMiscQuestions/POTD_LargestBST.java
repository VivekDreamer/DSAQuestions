// https://www.geeksforgeeks.org/problems/largest-bst/1
class Node{ 
  int data; 
  Node left, right; 
  public Node(int d)  { 
      data = d; 
      left = right = null; 
  } 
}

public class POTD_LargestBST{
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return largestBstUtil(root).maxSize;
    }
    static NodeValue largestBstUtil(Node root){
        if(root == null) return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        NodeValue left = largestBstUtil(root.left);
        NodeValue right = largestBstUtil(root.right);
        if(left.maxNode < root.data && right.minNode > root.data) 
            return new NodeValue(Math.max(root.data,right.maxNode),Math.min(root.data, left.minNode), (left.maxSize+right.maxSize+1));
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize,right.maxSize));
        
    }
    static class NodeValue{
        int maxNode;
        int minNode;
        int maxSize;
        NodeValue(int _maxNode, int _minNode, int _maxSize){
            this.maxNode = _maxNode;
            this.minNode = _minNode;
            this.maxSize = _maxSize;
        }
    }
}

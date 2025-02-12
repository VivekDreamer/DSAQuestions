class Node
{
     int data;
     Node left, right;

     public Node(int d)
     {
         data = d;
         left = right = null;
     }
}

public class POTD_KthSmallest1 {
    // Return the Kth smallest element in the given BST
    int res = -1, n = 0;
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int K) {
        // Write your code here
        kthSmallestElementUtil(root,K);
        return res;
    }
    public void kthSmallestElementUtil(Node root, int k){
        if(root == null)return;
        kthSmallestElementUtil(root.left,k);
        n++;
        if(n == k)res = root.data;
        kthSmallestElementUtil(root.right,k);
    }
}

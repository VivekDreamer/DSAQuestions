// https://www.geeksforgeeks.org/problems/array-to-bst4443/1
class Node{
  int data;
  Node left, right;
  Node(int item){
    data = item;
    left = right = null;
  }
}
public class POTD_ArrayToBST {
    Node arrtobst (int[] nums, int low, int high) {
        if (low > high)
            return null;
            
        int mid = (low + high)/2;
        Node root = new Node(nums[mid]);
        root.left = arrtobst(nums, low, mid-1);
        root.right = arrtobst(nums, mid+1, high);
        return root;
    }
    
    public Node sortedArrayToBST(int[] nums) {
        // Code here
        return arrtobst(nums, 0, nums.length-1);
    }
}

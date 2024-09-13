// https://www.geeksforgeeks.org/problems/mirror-tree/1
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} 

public class POTD_MirrorTree {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if(node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

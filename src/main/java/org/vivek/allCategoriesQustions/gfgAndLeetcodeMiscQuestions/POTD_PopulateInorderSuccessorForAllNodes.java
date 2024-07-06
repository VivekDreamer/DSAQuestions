// https://www.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
class Node {
    int data;
    Node left, right,next;
    
    public Node(int data){
        this.data = data;
    }
}
public class POTD_PopulateInorderSuccessorForAllNodes{
    Node prev = null;
    public void populateNext(Node root){
        //code here
        populateNextUtil(root);
    }
    void populateNextUtil(Node root){
        if(root == null)return;
        populateNextUtil(root.left);
        if(prev != null)prev.next = root;
        prev = root;
        populateNextUtil(root.right);
    }
}

class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
public class POTD_BinaryTreeToDLL
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	   ArrayList<Node> arr = new ArrayList<>();
	   fun(root,arr);
	   Node head = arr.get(0);
	   Node travel = head;
	   for(int i = 1; i < arr.size(); i++){
	       Node curr = arr.get(i);
	       travel.right = curr;
	       curr.left = travel;
	       travel = curr;
	   }
	   return head;
    }
    void fun(Node root, ArrayList<Node> arr){
        if(root == null)return;
        fun(root.left,arr);
        arr.add(root);
        fun(root.right,arr);
    }
}

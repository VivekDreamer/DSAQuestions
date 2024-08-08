// https://www.geeksforgeeks.org/problems/sum-tree/1
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
public class POTD_SumTree
{
    boolean f = true;
	boolean isSumTree(Node root)
	{
        isSumPropertyUtil(root);
        return f;
	}
	public int isSumPropertyUtil(Node root){
	    if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.data; 
        }
        int a = isSumPropertyUtil(root.left);
        int b = isSumPropertyUtil(root.right);
        if(root.data != a + b) f = false;
        return root.data + a + b;
    }
}

// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
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
public class POTD_LeftViewOfBinaryTree
{
    //Function to return list containing elements of left view of binary tree.
    /*ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i == 0) list.add(node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return list;
    }*/
    
    ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        leftViewUtil(root, list, 0);
        return list;
    }
    void leftViewUtil(Node root, ArrayList<Integer> list, int depth){
        if(root == null) return;
        if(depth == list.size()) list.add(root.data);
        leftViewUtil(root.left, list, depth+1);
        leftViewUtil(root.right, list, depth+1);
    }
}

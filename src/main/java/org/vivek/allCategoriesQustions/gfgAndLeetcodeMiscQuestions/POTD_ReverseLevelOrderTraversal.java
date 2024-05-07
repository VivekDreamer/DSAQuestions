// https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
class Node{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
public class POTD_ReverseLevelOrderTraversal{
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if(node == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node nod = queue.poll();
            ans.add(nod.data);
            if(nod.right != null) queue.add(nod.right);
            if(nod.left != null) queue.add(nod.left);
        }
        Collections.reverse(ans);
        return ans;
    }
}      

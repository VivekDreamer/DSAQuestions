// https://www.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
class Node{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
public class POTD_PrintAllNodesThatDontHaveSibling
{
    ArrayList<Integer> noSibling(Node node){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node root = queue.poll();
            Node left = root.left;
            Node right = root.right;
            if(left != null && right == null) {
                ans.add(left.data);
                queue.add(left);
            } else if(left == null && right != null){
                ans.add(right.data);
                queue.add(right);
            } else if(left != null && right != null){
                queue.add(left);
                queue.add(right);
            }
        }
        if(ans.size()==0) ans.add(-1);
        Collections.sort(ans);
        return ans;
    }
}

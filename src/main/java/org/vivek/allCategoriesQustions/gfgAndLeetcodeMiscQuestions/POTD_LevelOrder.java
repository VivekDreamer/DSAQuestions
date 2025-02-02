class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class POTD_LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node curr = queue.remove();
                arr.add(curr.data);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            levelOrder.add(arr);
        }
        return levelOrder;
    }
}

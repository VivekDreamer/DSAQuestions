public class Leetcode_TopViewBinaryTree {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.peek();
            Node node = pair.node;
            int vertical = pair.vertical;
            queue.remove();
            if(map.get(vertical) == null) map.put(vertical, node.data);
            if(node.left != null) queue.offer(new Pair(node.left, vertical-1));
            if(node.right != null) queue.offer(new Pair(node.right, vertical+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
class Pair{
    Node node;
    int vertical;
    Pair(Node _node, int _vertical){
        this.node = _node;
        this.vertical = _vertical;
    }
}

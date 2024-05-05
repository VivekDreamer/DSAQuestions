// https://www.geeksforgeeks.org/problems/vertical-sum/1
class Node{
int data;
Node left, right;
Node(int item)
  {
    data = item;
    left = right = null
  }
}

public class POTD_VerticalSum{
    public ArrayList <Integer> verticalSum(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int vertical = tuple.vertical;
            if(!map.containsKey(vertical)) map.put(vertical, new ArrayList<>());
            map.get(vertical).add(node.data);
            if(node.left != null) queue.add(new Tuple(node.left, vertical-1));
            if(node.right != null) queue.add(new Tuple(node.right, vertical+1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> arr : map.values()){
            int res = 0;
            for(int element : arr){
                res+=element;
            }
            ans.add(res);
        }
        return ans;
    }
    class Tuple{
        int vertical;
        Node node;
        Tuple(Node _node, int _vertical){
            this.node = _node;
            this.vertical = _vertical;
        }
    }
}

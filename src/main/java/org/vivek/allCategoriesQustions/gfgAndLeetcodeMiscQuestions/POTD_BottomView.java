// https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
class POTD_BottomView
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
       Queue<Pair> queue = new LinkedList<>();
       Map<Integer,Integer> map = new TreeMap<>();
       ArrayList<Integer> list = new ArrayList<>();
       if(root == null) return list;
       queue.add(new Pair(root, 0));
       while(!queue.isEmpty()){
           Pair pair = queue.poll();
           Node node = pair.node;
           int vertical = pair.vertical;
           map.put(vertical, node.data);
           if(node.left != null) queue.add(new Pair(node.left, vertical-1));
           if(node.right != null) queue.add(new Pair(node.right, vertical+1));
       }
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           list.add(entry.getValue());
       }
       return list;
    }
    static class Pair{
        Node node;
        int vertical;
        Pair(Node _node, int _vertical){
            this.node = _node;
            this.vertical = _vertical;
        }
    }
}

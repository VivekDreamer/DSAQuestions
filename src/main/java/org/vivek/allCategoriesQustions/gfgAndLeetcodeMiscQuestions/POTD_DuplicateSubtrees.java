// https://www.geeksforgeeks.org/problems/duplicate-subtrees/1
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

public class POTD_DuplicateSubtrees{
    public List<Node> printAllDups(Node root){
       Map<String,Integer> map = new HashMap<>();
       List<Node> res = new ArrayList<>();
       findAllDups(root, map, res);
       Collections.sort(res,(a,b)->a.data-b.data);
       return res;
    }
    public String findAllDups(Node root, Map<String, Integer> map, List<Node> res){
        if(root == null) return "N";
        String str = root.data+","+findAllDups(root.left, map, res)+","+findAllDups(root.right,map,res);
        if(map.containsKey(str) && map.get(str) == 1) res.add(root);
        map.put(str,map.getOrDefault(str,0)+1);
        return str;
    }
}

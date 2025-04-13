class Node {
  int val;
  ArrayList<Node> neighbours;
  public Node() {
    this.val = 0;
    this.neighbours = new ArrayList<>();
  }
  public Node(int val) {
    this.val = val;
    this.neighbours = new ArrayList<>();
  }
  public Node(int val, ArrayList<Node> neightbours) {
    this.val = val;
    this.neighbours = neighbours;
  }
}
public class POTD_Clone {
  Node cloneGraph(Node node) {
    Node start = node;
    Map<Node, Node> map = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    dfs(start,map,visited);
    addEdges(map);
    return start;
  }
  void dfs(Node node, Map<Node, Node> map, Set<Node> visited) {
    visited.add(node);
    Node cloneNode = new Node(node.val);
    map.put(node,cloneNode);
    for(Node neigh : node.neighbours) {
      if(!visited.contains(neigh)) {
          dfs(neigh,map,visited);
      }
    }
  }
  void addEdges(Map<Node,Node> map) {
    for(Map.Entry<Node,Node> entry : map.entrySet()) {
      Node originalNode = entry.getKey();
      for(Node neighbour : originalNode.neighbours) {
          entry.getValue().neighbours.add(map.get(neighbour));
      }  
    }
  }
}

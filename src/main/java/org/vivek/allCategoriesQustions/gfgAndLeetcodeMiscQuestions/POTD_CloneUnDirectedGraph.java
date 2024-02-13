package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/clone-graph/1
public class POTD_CloneUnDirectedGraph {
    Node cloneGraph(Node node){
        Node start = node;
        Map<Node,Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        dfs(start, map, visited);
        addEdges(map);
        return map.get(start);
    }
    void dfs(Node start, Map<Node, Node> map, Set<Node> visited){
        visited.add(start);
        Node copyNode = new Node(start.val);
        map.put(start,copyNode);
        for(Node p : start.neighbors){
            if(!visited.contains(p)){
                dfs(p,map,visited);
            }
        }
    }
    void addEdges(Map<Node, Node> map){
        for(Map.Entry<Node,Node> entry : map.entrySet()){
            Node originalNode = entry.getKey();
            for(Node originalNeighbour : originalNode.neighbors){
                entry.getValue().neighbors.add(map.get(originalNeighbour));
            }
        }
    }
    static class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}

package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;

//all trees are anyhow graph but all graph are not trees
//conditions that should apply to make graph into trees :
//1. the graph should be connected
//2. the graph should not contain any cycle
// https://www.geeksforgeeks.org/check-given-graph-tree/
public class T27_CheckIfGivenGraphIsTreeOrNot {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        if (graph.isTree()) {
            System.out.println("The graph is a tree.");
        } else {
            System.out.println("The graph is not a tree.");
        }
    }

    static class Graph{
        private int vertices;
        private List<List<Integer>> adjacencyList;
        public Graph(int vertices){
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>();
            for(int i = 0; i < vertices; i++){
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination){
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        private boolean isCyclicUtil(int vertex, boolean[] visited, int parent){
            visited[vertex] = true;
            for(Integer neighbour : adjacencyList.get(vertex)){
                if(!visited[neighbour]){
                    if(isCyclicUtil(neighbour, visited, vertex)){
                        return true;
                    }
                }else if(neighbour != parent) return true;
            }
            return false;
        }

        private boolean isTree() {
            boolean[] visited = new boolean[vertices];
            if (isCyclicUtil(0, visited, -1)) 
                return false; // Contains a cycle
            for (boolean v : visited) 
                if (!v) 
                    return false; // Not connected
            return true; // It's a tree
        }
    
    }
}

// https://www.geeksforgeeks.org/problems/number-of-good-components--170647/1
class POTD_NumberOfGoodComponents {
    static int vCount;
    static int eCount;
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            int ui = edge[0]-1;
            int vi = edge[1]-1;
            adjList.get(ui).add(vi);
            adjList.get(vi).add(ui);
        }
        int numberOfGoodComponent = 0;
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                vCount = 0;
                eCount = 0;
                dfs(i, adjList, vis);
                if(eCount == vCount * (vCount - 1)) numberOfGoodComponent++;
            }
        }
        return numberOfGoodComponent;
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        vCount++;
        eCount += adjList.get(node).size();
        for(int neighbor : adjList.get(node)){
            if(!vis[neighbor]){
                dfs(neighbor,adjList,vis);
            }
        }
    }
}

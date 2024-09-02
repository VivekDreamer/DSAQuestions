// https://www.geeksforgeeks.org/problems/minimum-cost-path3833/1
class POTD_MinimumCostPath{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid){
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n+1][m+1];
        for(int[] arr : dist) Arrays.fill(arr,(int)(1e9));
        dist[0][0] = grid[0][0];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        Queue<Tuple> queue = new PriorityQueue<>((a,b)->a.first-b.first);
        queue.add(new Tuple(grid[0][0],0,0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int dis = tuple.first;
            int row = tuple.second;
            int col = tuple.third;
            for(int i = 0; i < 4; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && dis + grid[newRow][newCol] < dist[newRow][newCol]){
                    dist[newRow][newCol] = dis + grid[newRow][newCol];
                    if(newRow == n-1 && newCol == m-1) return (dis + grid[newRow][newCol]);
                    queue.add(new Tuple(dis + grid[newRow][newCol], newRow, newCol));
                }
            }
        }
        return -1;
    }
    static class Tuple{
        int first;
        int second;
        int third;
        public Tuple(int _first, int _second, int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
}

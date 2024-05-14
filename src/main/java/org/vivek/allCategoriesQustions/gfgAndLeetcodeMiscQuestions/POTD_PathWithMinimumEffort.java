// https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1

class POTD_PathWithMinimumEffort {
    
    int MinimumEffort(int heights[][]) {
        // Create a priority queue containing pairs of cells 
        // and their respective distance from the source cell in the 
        // form {diff, {row of cell, col of cell}}.
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)  -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;
        
        // Create a priority queue containing pairs of cells 
        // and their respective distance from the source cell in the 
        // form {diff, {row of cell, col of cell}}.
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        dist[0][0] = 0; 
        pq.add(new Tuple(0, 0, 0)); 
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        while(!pq.isEmpty()){
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row  = it.row;
            int col  = it.col;
            
            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            
            if(row == n-1 && col == m-1) return diff; 
            
            for(int i = 0; i < 4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];
                
                // Checking validity of the cell.
                if(newr>=0 && newc >=0 && newr < n && newc < m) {
                 
                 // Effort can be calculated as the max value of differences 
                 // between the heights of the node and its adjacent nodes.
                    int  newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    
                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc)); 
                    }
                }
            }
        }
        // If the destination is unreachable.
        return 0;
    }
    static class Tuple{
        int distance;
        int row;
        int col;
        Tuple(int _distance, int  _row, int _col){
            this.distance = _distance;
            this.row = _row;
            this.col = _col;
        }
    }
}

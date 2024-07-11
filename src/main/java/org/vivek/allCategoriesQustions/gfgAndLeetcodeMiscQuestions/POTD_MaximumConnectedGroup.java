class POTD_MaximumConnectedGroup {
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        //step 1
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for(int idx = 0; idx < 4; idx++){
                    int newr = row + dr[idx];
                    int newc = col + dc[idx];
                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo , adjNodeNo);
                    }
                }
            }
        }
        
        //step 2
        int mx = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if (grid[row][col] == 1) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for(int idx = 0; idx < 4; idx++){
                    int newr = row + dr[idx];
                    int newc = col + dc[idx];
                    if(isValid(newr,newc,n)){
                        if(grid[newr][newc] == 1){
                            components.add(ds.findUParent(newr * n + newc));
                        }
                    }
                }
                int sizeTotals = 0;
                for(Integer parent : components)
                    sizeTotals += ds.size.get(parent);
                mx = Math.max(mx , sizeTotals+1);
            }
        }
        
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUParent(cellNo)));
        }
        return mx;
        
    }
    private boolean isValid(int newr, int newc, int n){
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
    
}
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    public int findUParent(int node){
        if(node == parent.get(node))
            return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v)return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v , ulp_u);
        }
        else{
            parent.set(ulp_v , ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u , rankU+1);
        }
     }
    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v)return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

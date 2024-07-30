// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class POTD_RatInAMaze {
    public ArrayList<String> findPath(int[][] m) {
        int n = m.length;
        int[][] vis = new int[n][n];
        for(int[] row : vis) Arrays.fill(row,0);
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) findPathUtil(0,0,m,n,vis,ans,"");
        return ans;
    }
    public static void findPathUtil(int i, int j, int[][] m, int n, int[][] vis, ArrayList<String> ans, String move){
        if(i == n-1 && j == n-1) {
            ans.add(move);
            return;
        }
        if(i+1 < n && vis[i+1][j] == 0 && m[i+1][j] == 1){
            vis[i][j] = 1;
            findPathUtil(i+1,j,m,n,vis,ans,move+"D");
            vis[i][j] = 0;
        }
        if(i-1 >= 0 && vis[i-1][j] == 0 && m[i-1][j] == 1){
            vis[i][j] = 1;
            findPathUtil(i-1,j,m,n,vis,ans,move+"U");
            vis[i][j] = 0;
        }
        if(j+1 < n && vis[i][j+1] == 0 && m[i][j+1] == 1){
            vis[i][j] = 1;
            findPathUtil(i,j+1,m,n,vis,ans,move+"R");
            vis[i][j] = 0;
        }if(j-1 >= 0 && vis[i][j-1] == 0 && m[i][j-1] == 1){
            vis[i][j] = 1;
            findPathUtil(i,j-1,m,n,vis,ans,move+"L");
            vis[i][j] = 0;
        }
        
    }
    
}

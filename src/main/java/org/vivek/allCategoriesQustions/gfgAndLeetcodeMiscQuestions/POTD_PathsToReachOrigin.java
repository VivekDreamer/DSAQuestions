// https://www.geeksforgeeks.org/problems/paths-to-reach-origin3850/1
class POTD_PathsToReachOrigin{
    /*static int MOD = 1000000007;
    public static int ways(int n, int m){
        int[][] memo = new int[n+1][m+1];
        for(int[] arr : memo)
            Arrays.fill(arr, -1);
        return waysUtil(n, m, memo)%MOD;
    }
    public static int waysUtil(int n, int m, int[][] memo){
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(memo[n][m] != -1) return memo[n][m]%MOD;
        int x = waysUtil(n-1,m,memo)%MOD;
        int y = waysUtil(n,m-1,memo)%MOD;
        return memo[n][m] = (x + y)%MOD;
    }*/
    
    static int MOD = 1000000007;
    public static int ways(int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if( i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
            }
        }
        return dp[n][m];
    }
}

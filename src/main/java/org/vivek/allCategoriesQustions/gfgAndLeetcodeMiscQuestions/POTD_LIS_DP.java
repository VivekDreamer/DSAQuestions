class POTD_LIS_DP {
    static int lis(int a[]) {
        int n = a.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return longestIncreasingSubsquenceUtil(a,0,-1,n,dp);
    }
    private static int longestIncreasingSubsquenceUtil(int[] a, int idx, int prevIdx, int n, int[][] dp) {
        if(idx == n) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
        int len = longestIncreasingSubsquenceUtil(a,idx+1,prevIdx,n,dp);
        if(prevIdx == -1 || a[idx] > a[prevIdx])
            len = Math.max(len, 1 + longestIncreasingSubsquenceUtil(a, idx+1, idx, n, dp));
        return dp[idx][prevIdx+1] = len;
        
    }
}

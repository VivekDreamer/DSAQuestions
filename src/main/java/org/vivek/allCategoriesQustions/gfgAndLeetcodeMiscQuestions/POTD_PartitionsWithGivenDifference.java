// https://geeksforgeeks.org/problems/partitions-with-given-difference/1
class POTD_PartitionsWithGivenDifference{
    int mod = (int)1e9 + 7;
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum = Arrays.stream(arr).sum();
        if((d+sum)%2 != 0) return 0;
        int sum1 = (sum+d)/2;
        
        // reduced : find counts of subset with sum equal to t
        int[][] dp = new int[n+1][sum1+1];
        dp[0][0] = 1;
        
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < sum1 + 1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = (dp[i-1][j]%mod + dp[i-1][j-arr[i-1]]%mod)%mod;
                else
                    dp[i][j] = dp[i-1][j]%mod;
            }
        }
        return dp[n][sum1];
    }
}

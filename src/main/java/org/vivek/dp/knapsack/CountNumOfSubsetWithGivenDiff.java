package org.vivek.dp.knapsack;

import java.util.Arrays;

public class CountNumOfSubsetWithGivenDiff {
    public static void main(String[] args) {
        int n = 4;
        int d = 0;
        int[] arr = {1,1,1,1};
        int res = countPartitions(n, d, arr);
        int res1 = countPartitionsTopDown(n,d,arr);
        System.out.println(res);
        System.out.println(res1);
    }
    private static int countPartitions(int n, int d, int arr[]){
        int sum = Arrays.stream(arr).sum();
        if((sum+d)%2 != 0) return 0;
        int sum1 = (sum+d)/2;
        int[][] memo = new int[n+1][sum1+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return countPartitionsUtil(n, arr, sum1, memo);
    }
    private static int countPartitionsUtil(int n, int[] arr, int sum, int[][] memo) {
        if(n == 0){
            return sum == 0? 1 : 0;
        }
        if(memo[n][sum] != -1) return memo[n][sum];
        if(arr[n-1] <= sum)
            memo[n][sum] = countPartitionsUtil(n-1, arr, sum-arr[n-1], memo) + countPartitionsUtil(n-1, arr, sum, memo);
        else    
            memo[n][sum] = countPartitionsUtil(n-1, arr, sum, memo);
        return memo[n][sum];
    }
    private static int countPartitionsTopDown(int n, int d, int[] arr){
        int sum = Arrays.stream(arr).sum();
        if((sum+d)%2 != 0) return 0;
        int sum1 = (sum+d)/2;
        // reduced : find counts of subset with sum equal to t
        int[][] dp = new int[n+1][sum1+1];
        dp[0][0] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < sum1+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum1];
    }
}

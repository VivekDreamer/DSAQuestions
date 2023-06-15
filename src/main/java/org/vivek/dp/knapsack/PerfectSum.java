package org.vivek.dp.knapsack;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class PerfectSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 10;
        int ans = perfectSum(arr,n,sum);
        int ans1 = perfectSumTopDown(arr,n,sum);
        System.out.println(ans);
        System.out.println(ans1);
    }
    private static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
        int memo[][] = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return perfectSumUtil(arr, n, sum,memo);
	}
    private static int perfectSumUtil(int[] arr, int n, int sum, int[][] memo) {
        if(n == 0){
            return sum == 0 ? 1 : 0;
        }
        if(memo[n][sum] != -1) return memo[n][sum];
        if(arr[n-1] <= sum){
            memo[n][sum] = perfectSumUtil(arr, n-1, sum-arr[n-1], memo) + perfectSumUtil(arr, n-1, sum, memo);
        }
        else memo[n][sum] = perfectSumUtil(arr, n-1, sum, memo);
        return memo[n][sum];
    } 
    private static int perfectSumTopDown(int[] arr, int n, int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0 ; i < n+1; i++)
        {
            if(i == 0)
                dp[i][0] = 1;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }
}

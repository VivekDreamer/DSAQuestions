package org.vivek.dp.knapsack;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
//related to subset sum problem
public class EqualSumPartition {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 5, 11, 5};
        int ans = equalPartition(n,arr);
        int ans1 = equalPartitionTopDown(n,arr);
        System.out.println(ans);
        System.out.println(ans1);
    }
    static int equalPartition(int n, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum%2 != 0)
            return 0;
        else{
            int[][] memo = new int[n+1][sum+1];
            for(int[] row : memo)
                Arrays.fill(row,-1);
            return equalPartitionUtil(n, arr,sum/2,memo);
        }
    }
    private static int equalPartitionUtil(int n, int[] arr, int sum, int[][] memo) {
        if(sum == 0) return 1;
        if(n == 0) return 0;
        if(memo[n][sum] != -1)
            return memo[n][sum];
        int res = 0;
        if(arr[n-1] <= sum)
            res = equalPartitionUtil(n-1, arr, sum-arr[n-1],memo);
        return memo[n][sum] = res == 1? res : equalPartitionUtil(n-1, arr, sum, memo);
    }
    static int equalPartitionTopDown(int n, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum%2!=0)return 0;
        int sum1 = sum/2;
        int[][] dp = new int[n+1][sum1+1];
        //initialize the dp array
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum1+1; j++){
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < sum1+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = Math.max(dp[i-1][j-arr[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum1];
    }
}

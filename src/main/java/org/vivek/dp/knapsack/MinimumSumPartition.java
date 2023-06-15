package org.vivek.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/0
public class MinimumSumPartition {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1,6,11,5};
        int diff = minDifference(arr, n);
        int minDiff = minDifferenceTopDown(arr,n);
        System.out.println(diff);
        System.out.println(minDiff);
    }
    private static int minDifference(int arr[], int n) 
	{
        int sum = Arrays.stream(arr).sum();
        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return minDifferenceUtil(arr, n,0,0,memo);
    }
    private static int minDifferenceUtil(int[] arr, int n, int sum1, int sum2, int[][] memo) 
    {
        if(n == 0) return Math.abs(sum2-sum1);
        if(memo[n][Math.abs(sum2-sum1)] != -1) return memo[n][Math.abs(sum2-sum1)];
        int ans1 = minDifferenceUtil(arr, n-1, sum1+arr[n-1], sum2, memo);
        int ans2 = minDifferenceUtil(arr, n-1, sum1, sum2+arr[n-1], memo);
        return memo[n][Math.abs(sum2-sum1)] = Math.min(ans1,ans2);
    }
    private static int minDifferenceTopDown(int arr[], int n)
    {
        int sum = Arrays.stream(arr).sum();
        //just fill dp array as you did in subset sum problem as true - false
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;

            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= sum/2; i++){
            if(dp[n][i]) list.add(i);
        }
        for(int num : list){
            min = Math.min(min, sum-2*num);
        }
        return min;
    }
}

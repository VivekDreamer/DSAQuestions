package org.vivek.dp.knapsack;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSum {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean ans = isSubsetSum(n, arr, sum);
        boolean ans1 = isSubsetSumTopDown(n, arr, sum);
        System.out.println(ans);
        System.out.println(ans1);
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] memo = new int[N+1][sum+1];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return isSubsetSumUtil(N, arr, sum, memo);
    }
    private static Boolean isSubsetSumUtil(int n, int[] arr, int sum, int[][] memo) {
        if(sum == 0)return true;
        if(n == 0)return false;
        if(memo[n][sum] != -1) return memo[n][sum]==0 ? false:true;
        boolean res = false;
        if(arr[n-1] <= sum)
            res = isSubsetSumUtil(n-1, arr, sum-arr[n-1],memo);
        memo[n][sum] = res?1:isSubsetSumUtil(n-1, arr, sum, memo)?1:0;
        return memo[n][sum] == 1? true:false;
    }
    //using top-down approach
    static boolean isSubsetSumTopDown(int N, int arr[], int sum)
    {
        boolean[][] dp = new boolean[N+1][sum+1];
        //initialize the dp array according to the base condition
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][sum];
    }
}

package org.vivek.dp.unbounded;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
public class KnapsackWithDuplicateItems {
    public static void main(String[] args) {
        int n = 2;
        int w = 3;
        int[] val = {1,1};
        int[] wt = {2,1};
        int res = knapSack(n, w, val, wt);
        int res1 = knapSackTopDown(n, w, val, wt);
        System.out.println(res);
        System.out.println(res1);
    }
    //recursion memoization
    private static int knapSack(int n, int w, int[] val, int[] wt)
    {
        int[][] memo = new int[n+1][w+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return knapSackUtil(n, w, val, wt, memo);
    }
    private static int knapSackUtil(int n, int w, int[] val, int[] wt, int[][] memo) 
    {
        if(n == 0 || w == 0) return 0;
        if(memo[n][w] != -1) return memo[n][w];
        if(wt[n-1] <= w)
            return memo[n][w] = Math.max(knapSackUtil(n, w-wt[n-1], val, wt, memo)+val[n-1], knapSackUtil(n-1, w, val, wt, memo));
        return memo[n][w] = knapSackUtil(n-1,w,val,wt, memo);
    }
    //dp top down
    private static int knapSackTopDown(int n, int w, int[] val, int[] wt)
    {
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < w+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < w+1; j++){
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-wt[i-1]]+val[i-1]);
                else   
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }
}

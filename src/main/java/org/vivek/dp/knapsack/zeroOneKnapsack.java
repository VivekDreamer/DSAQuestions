package org.vivek.dp.knapsack;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class zeroOneKnapsack {
    public static void main(String[] args) {
        int W = 4;
        int n = 3;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};
        int res = knapSack(W, weight, values, n);
        int res1 = knapSackTopDown(W,weight,values,n);
        System.out.println(res);
        System.out.println(res1);
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        //memoization
        //size of 2D array will be the variables which are changing in the recursive function calls
        int[][] memo = new int[n+1][W+1];
        //always initialize the memo array with -1
        for(int[] row : memo)
            Arrays.fill(row, -1);
        return knapSackUtil(W, wt, val, n, memo);
    } 
    private static int knapSackUtil(int w, int[] wt, int[] val, int n,int[][] memo) 
    {
        //base condition
        if(n == 0 || w == 0)
            return 0;
        //check if at given coordinates, value is not -1 then, return it from here only. No need to make the recursive calls.
        if(memo[n][w] != -1)
            return memo[n][w];
        //choice diagram
        //either you pick or not pick
        int ans = 0;
        if(wt[n-1] <= w){
            ans = val[n-1] + knapSackUtil(w-wt[n-1], wt, val, n-1, memo);
        }
        return memo[n][w] = Math.max(ans,knapSackUtil(w, wt, val, n-1, memo));
    }
    //knapsnack top-down approach
    static int knapSackTopDown(int W, int wt[], int val[], int n){
        //here i and j will be the fields which will change throughout.
        //i = n and j = W
        int[][] dp = new int[n+1][W+1];
        //step 1- initialize the dp 
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < W+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}

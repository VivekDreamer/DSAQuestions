package org.vivek.dp.unbounded;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
public class RodCuttingProblem {
    public static void main(String[] args) {
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int res = cutRod(price,n);
        int res1 = cutRodTopDown(price,n);
        System.out.println(res);
        System.out.println(res1);
    }
    private static int cutRod(int price[], int n) {
        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return cutRodUtil(price,n,n,memo);
    }
    private static int cutRodUtil(int[] price, int n, int len, int[][] memo) {
        if(n == 0) return 0;
        if(memo[n][len] != -1) return memo[n][len];
        if(len>=n)
            return memo[n][len] =  Math.max(cutRodUtil(price, n-1, len, memo), price[n-1]+cutRodUtil(price, n, len-n, memo));
        return memo[n][len] =  cutRodUtil(price, n-1, len,memo);
    }
    private static int cutRodTopDown(int price[], int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        //here i represents pieces len
        //j represents the len of whole stick
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i <= j)
                    dp[i][j] = Math.max(dp[i-1][j], price[i-1]+dp[i-1][j-i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n];
    }
}

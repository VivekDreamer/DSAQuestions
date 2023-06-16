package org.vivek.dp.unbounded;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/coin-change2448/1
public class CoinExchangeProblem1 {
    public static void main(String[] args) {
        int sum = 4;
        int N = 3;
        int coins[] = {1,2,3};
        long ways = count(coins, N, sum);
        long countTopDown = countTopDown(coins,N,sum);
        System.out.println(ways);
        System.out.println(countTopDown);
    }
    public static long count(int coins[], int N, int sum) {
        long[][] memo = new long[N+1][sum+1];
        for(long[] row : memo)
            Arrays.fill(row,-1);
        return countHelper(coins,N,sum,memo);
    }
    private static long countHelper(int[] coins, int n, int sum, long[][] memo) {
        if(n == 0) return 0;
        if(sum == 0) return 1;
        if(memo[n][sum] != -1) return memo[n][sum];
        if(coins[n-1] <= sum)
            return memo[n][sum] = countHelper(coins, n-1, sum,memo) + countHelper(coins, n, sum-coins[n-1], memo);
        else return memo[n][sum] = countHelper(coins, n-1, sum, memo);
    }
    public static long countTopDown(int coins[], int N, int sum) {
        long[][] dp = new long[N+1][sum+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(j == 0)
                    dp[i][j] = 1;
                if(i == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][sum];
    }
}

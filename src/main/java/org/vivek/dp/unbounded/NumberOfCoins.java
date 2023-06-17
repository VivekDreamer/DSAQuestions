package org.vivek.dp.unbounded;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
public class NumberOfCoins {
    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        int n = 3;
        int sum = 30;
        int minCoins = minCoins(coins, n, sum);
        int minCoinsTopDown = minCoinsTopDown(coins, n, sum);
        System.out.println(minCoins);
        System.out.println(minCoinsTopDown);
    }

    //using memoization
    public static int minCoins(int coins[], int n, int sum) 
	{
        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return minCoinsUtil(coins, n, sum, memo);
    }
    public static int minCoinsUtil(int coins[], int n, int sum,int[][] memo) {
        if(sum == 0)
            memo[n][sum] = 0;
        if(n == 0)
            memo[n][sum] = Integer.MAX_VALUE-1;
        if(memo[n][sum] != -1) return memo[n][sum];
        if(coins[n-1] <= sum)
            return memo[n][sum] = Math.min(1+minCoinsUtil(coins, n, sum-coins[n-1], memo), minCoinsUtil(coins, n-1, sum, memo));
        return memo[n][sum] = minCoinsUtil(coins, n-1, sum, memo);
    }
    //using top-down
    public static int minCoinsTopDown(int coins[], int n, int sum){
        int[][] dp = new int[n+1][sum+1];
        //here i represents the n which is number of elements in array
        //here j represents the sum
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(j == 0)
                    dp[i][j] = 0;
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        //initialising the second row
        for(int i = 1; i < 2; i++){
            for(int j = 1; j < sum+1; j++){
                if(j % coins[0] == 0)
                    dp[i][j] = j/coins[0];
                else
                    dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(coins[i-1] <= j)
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum] == (Integer.MAX_VALUE -1) ? -1 : dp[n][sum];
    }
}

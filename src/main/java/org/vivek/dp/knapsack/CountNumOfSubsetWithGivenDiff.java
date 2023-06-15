package org.vivek.dp.knapsack;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1
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
        // 1)  We are initialising first column to 1, assuming there is only 1 way to make subset sum equal to 0,  i.e. null subset, BUT this fails if we have 0's as elements of array. If we have a single 0 present in the array, then the subsets will be '{}, {0}' whose sum will be 0. Hence, there can be more than 1 way to make sum==0.
        // FIX: Don't initialise the first col to be 1. Everything will be initialized to 0 except the first cell in the table i.e. dp[0][0]=1. AND j will start from 0 instead of 1.
        // 2)  In the derived formula, target = (diff+totalSum) / 2, NOTICE that (diff+totalSum) must be even for target to be a whole number, else it's not possible to find a decimal target in subset sum. Hence, we also need to take care of the test cases where it's not possible to partition the array.
        // FIX: Check, if it's odd,  there is no way --> if((diff+totalSum)%2 != 0) return 0;

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

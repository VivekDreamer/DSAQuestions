package org.vivek.dp.mixedQuestion;

import java.util.Arrays;

public class MaxSumWithoutAdjacentsTwo {
    public static void main(String[] args) {
        int arr[] = {3000,2000,1000,3,10};
        int findMaxSum = findMaxSum(arr, arr.length);
        System.out.println(findMaxSum);
        int findMaxSumDP = findMaxSumDP(arr, arr.length);
        System.out.println(findMaxSumDP);
        int findMaxSumApproach = findMaxSumApproach(arr, arr.length);
        System.out.println(findMaxSumApproach);
    }
    //by memo
    private static int findMaxSum(int arr[], int n) {
        int[][] memo = new int[n+1][3];
        for(int[] row : memo) Arrays.fill(row,-1);
        return findMaxSumUtil(arr,n,0,memo);
    }
    private static int findMaxSumUtil(int[] arr, int n, int k, int[][] memo) {
        if(n == 0) return 0;
        if(n == 1 && k < 2) return arr[n-1];
        if(memo[n][k] != -1) return memo[n][k];
        int ans1 = 0;
        int ans2 = 0;
        if(k < 2)ans1 = arr[n-1]+findMaxSumUtil(arr, n-1, k+1, memo);
        ans2 = findMaxSumUtil(arr, n-1, 0, memo);
       return memo[n][k] =  Math.max(ans1,ans2);
    }

    //by dp 
    private static int findMaxSumDP(int arr[], int n) {
        int[][] dp = new int[n+1][3];
        int i = 0;
        while(i < 2){
            dp[1][i] = arr[0];
            i++;
        }
        i = 1;
        while(i <= n){
            int j = 0;
            while(j <= 2){
                int ans1 = 0;
                int ans2 = 0;
                if(j < 2) ans1 = arr[i-1] + dp[i-1][j+1];
                ans2 = dp[i-1][0];
                dp[i][j] = Math.max(ans1,ans2);
                j++;
            }
            i++;
        }
        return dp[n][0];
    }

    private static int findMaxSumApproach(int arr[], int n) {
         // Stores result for subarray arr[0..i], i.e.,
        // maximum possible sum in subarray arr[0..i]
        // such that no three elements are consecutive.
        int sum[] = new int[n];
       
        // Base cases (process first three elements)
        if (n >= 1)
            sum[0] = arr[0];
       
        if (n >= 2)
            sum[1] = arr[0] + arr[1];
       
        if (n > 2)
            sum[2] = Math.max(sum[1], Math.max(arr[1] +
                                   arr[2], arr[0] + arr[2]));
       
        // Process rest of the elements
        // We have three cases
        // 1) Exclude arr[i], i.e., sum[i] = sum[i-1]
        // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
        // 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1]
        for (int i = 3; i < n; i++)
            sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]),
                         arr[i] + arr[i - 1] + sum[i - 3]);
       
        return sum[n - 1];
    }
}

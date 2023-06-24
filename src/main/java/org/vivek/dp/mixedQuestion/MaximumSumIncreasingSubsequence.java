package org.vivek.dp.mixedQuestion;
//https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int N = 5; int arr[] = {1, 101, 2, 3, 100};
        int maxSumIS = maxSumIS(arr, N);
        System.out.println(maxSumIS);
    }
    public static int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[] dp = new int[n];
	    for(int i = 0; i < n; i++)
	        dp[i] = arr[i];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < i; j++){
	            if(arr[i] > arr[j]){
	                dp[i] = Math.max(dp[i], arr[i]+dp[j]);
	            }
	        }
	    }
	    int maxi = 0;
	    for(int i = 0; i < n; i++)
	        maxi = Math.max(maxi,dp[i]);
	    return maxi;
	}  
}

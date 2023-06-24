package org.vivek.dp.mixedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int n = 16;
        int A[]={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int longestSubsequence = longestSubsequence(n, A);
        System.out.println(longestSubsequence);
        int longestSubsequenceTabulation = longestSubsequenceTabulation(n,A);
        System.out.println(longestSubsequenceTabulation);
        int longestSubsequenceOptimized = longestSubsequenceOptimized(n, A);
        System.out.println(longestSubsequenceOptimized);
        printingLIS(n,A);
        int longestSubsequenceUsingBS = longestSubsequenceUsingBS(n, A);
        System.out.println(longestSubsequenceUsingBS);
    }
    private static int longestSubsequence(int n, int[] a){
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return longestIncreasingSubsquenceUtil(a,0,-1,n,dp);
    }
    private static int longestIncreasingSubsquenceUtil(int[] a, int idx, int prevIdx, int n, int[][] dp) {
        if(idx == n) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
        int len = longestIncreasingSubsquenceUtil(a,idx+1,prevIdx,n,dp);
        if(prevIdx == -1 || a[idx] > a[prevIdx])
            len = Math.max(len, 1 + longestIncreasingSubsquenceUtil(a, idx+1, idx, n, dp));
        return dp[idx][prevIdx+1] = len;
    }
    private static int longestSubsequenceTabulation(int n, int[] arr){
        int[][] dp = new int[n+1][n+1];
         for(int idx = n-1; idx >= 0; idx--){
            for(int prevIdx = idx-1; prevIdx >= -1; prevIdx--){
                int len = dp[idx+1][prevIdx+1];
                if(prevIdx == -1 || arr[idx] > arr[prevIdx])
                    len = Math.max(len,1+ dp[idx+1][idx+1]);
                dp[idx][prevIdx+1] = len;
            }
         }
         return dp[0][-1+1];
    }

    private static int longestSubsequenceOptimized(int n, int[] arr){
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 0 ; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i]){ 
                    dp[i] = Math.max(dp[i] , 1 + dp[prev]);
                }
                maxi = Math.max(maxi,dp[i]);
            }
        }
        return maxi;
    }

    private static void printingLIS(int n, int[] arr){
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp,1);
        int lastIndex = 0;
        int maxi = 1;
        for(int i = 0 ; i < n; i++){
            hash[i] = i; 
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i] && dp[i] < 1 + dp[prev]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
                if(dp[i] > maxi)
                {
                    maxi = dp[i];
                    lastIndex = i;
                }
            }
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);          
        }
        Collections.reverse(lis);
        System.out.println(lis);
    }

    private static int longestSubsequenceUsingBS(int n, int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
            }
            else{
                int idx = Collections.binarySearch(list,arr[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                list.set(idx,arr[i]);
            }
        }
        return list.size();
    }
}

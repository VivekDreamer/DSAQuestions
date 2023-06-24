package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://practice.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1
public class LongestSubsequence1 {
    public static void main(String[] args) {
        int N = 7,A[] = {10, 9, 4, 5, 4, 8, 6};
        int longestSubsequence = longestSubsequence(N, A);
        System.out.println(longestSubsequence);
        int longestSubsequenceDP = longestSubsequenceDP(N, A);
        System.out.println(longestSubsequenceDP);
    }
    private static int longestSubsequence(int n, int a[]){
        int maxCount = 0;
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int l = 0;
            
            if (m.containsKey(a[i] - 1))
                l = m.get(a[i] - 1);
            
            if (m.containsKey(a[i] + 1) && m.get(a[i] + 1) > l)
                l = m.get(a[i] + 1);
            
            m.put(a[i], l + 1);
            maxCount = Math.max(maxCount, m.get(a[i]));
        }
        return maxCount;
    }

    private static int longestSubsequenceDP(int n, int arr[])
    {
        // Same approach as that of longest increasing subsequence
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(Math.abs(arr[i]-arr[prev]) == 1) dp[i] = Math.max(dp[i],dp[prev]+1);
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}

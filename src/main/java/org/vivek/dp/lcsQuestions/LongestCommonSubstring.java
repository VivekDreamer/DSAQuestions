package org.vivek.dp.lcsQuestions;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
public class LongestCommonSubstring {
    static int ans = 0;
    public static void main(String[] args) {
       String S1 = "ABCDGH", S2 = "ACDGHR"; int n = 6, m = 6;
       int longestCommonSubstr = longestCommonSubstr(S1,S2,n,m);
       int longestCommonSubstrTopDown = longestCommonSubstrTopDown(S1, S2, n, m);
       System.out.println(longestCommonSubstr);
       System.out.println(longestCommonSubstrTopDown);
    }
    private static int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] memo = new int[n+1][m+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        longestCommonSubstrUtil(S1, S2, n, m, memo);
        return ans;
    }
    private static int longestCommonSubstrUtil(String s1, String s2, int n, int m, int[][] memo){
        if(n == 0 || m == 0)return 0;
        int temp = 0;
        if(memo[n][m] != -1) return memo[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)) temp = 1 + longestCommonSubstrUtil(s1,s2,n-1,m-1,memo);
        longestCommonSubstrUtil(s1,s2,n-1,m,memo);
        longestCommonSubstrUtil(s1,s2,n,m-1,memo);
        ans = Math.max(ans,temp);
        return memo[n][m] = temp;
    }
    private static int longestCommonSubstrTopDown(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        int maxLength = 0;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength;
    }
}

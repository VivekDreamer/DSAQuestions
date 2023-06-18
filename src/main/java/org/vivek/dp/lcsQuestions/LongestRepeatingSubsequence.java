package org.vivek.dp.lcsQuestions;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "axxzxy";
        int longestRepeatingSubsequence = longestRepeatingSubsequence(str);
        System.out.println(longestRepeatingSubsequence);
        int longestRepeatingSubsequenceTopdown = longestRepeatingSubsequenceTopdown(str);
        System.out.println(longestRepeatingSubsequenceTopdown);
    }
    public static int longestRepeatingSubsequenceTopdown(String str)
    {
        // code here
        return longestRepeatingSubsequenceTopdownUtil(str,str,str.length(),str.length());
    }
    public static int longestRepeatingSubsequenceTopdownUtil(String str1, String str2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if((str1.charAt(i-1) == str2.charAt(j-1)) && i != j)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
    public static int longestRepeatingSubsequence(String str){
        int[][] memo = new int[str.length()+1][str.length()+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return longestRepeatingSubsequenceUtil(str,str,str.length(),str.length(),memo);
    }
    private static int longestRepeatingSubsequenceUtil(String str1, String str2, int n, int m, int[][] memo) {
        if(n == 0 || m == 0)
            return 0;
        if(memo[n][m] != -1) return memo[n][m];
        if((str1.charAt(n-1) == str2.charAt(m-1)) && n != m) return memo[n][m] = 1 + longestRepeatingSubsequenceUtil(str1,str2,n-1,m-1,memo);
        else return memo[n][m] = Math.max(longestRepeatingSubsequenceUtil(str1, str2, n-1, m, memo), longestRepeatingSubsequenceUtil(str1, str2, n, m-1, memo));
    }
    
}

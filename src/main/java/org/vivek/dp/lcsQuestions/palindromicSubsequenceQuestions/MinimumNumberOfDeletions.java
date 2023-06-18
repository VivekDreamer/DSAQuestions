package org.vivek.dp.lcsQuestions.palindromicSubsequenceQuestions;

import java.util.Arrays;

//this problem resembles with the longest palindromic subsequence
//we will get minimum number of deleteion by doing following operation:
//len(str) - len(lps)
//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
public class MinimumNumberOfDeletions {
    public static void main(String[] args) {
        int n = 7; String str = "aebcbda";
        int minDeletionsTopdown = minDeletionsTopdown(str, n);
        System.out.println(minDeletionsTopdown);
        int minDeletions = minDeletions(str,n);
        System.out.println(minDeletions);
    }
    private static int minDeletionsTopdown(String str1, int n)
    {
        // code here
        StringBuffer sb = new StringBuffer(str1);
        String str2 = sb.reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (n - dp[n][n]);
    }
    private static int minDeletions(String str1, int n)
    {
        // code here
        //this problem resembles with the longest palindromic subsequence
        //we will get minimum number of deleteion by doing following operation:
        //len(str) - len(lps)
        StringBuffer sb = new StringBuffer(str1);
        String str2 = sb.reverse().toString();
        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return (n - lps(str1,str2,n,n,memo)); 
    }
    private static int lps(String str1, String str2, int x, int y, int[][] memo){
        if(x == 0 || y == 0)
            return 0;
        if(memo[x][y] != -1) return memo[x][y];
        if(str1.charAt(x-1) == str2.charAt(y-1)) return memo[x][y] = 1 + lps(str1,str2,x-1,y-1,memo);
        else return memo[x][y] = Math.max(lps(str1,str2,x-1,y,memo),lps(str1,str2,x,y-1,memo));
    }
}

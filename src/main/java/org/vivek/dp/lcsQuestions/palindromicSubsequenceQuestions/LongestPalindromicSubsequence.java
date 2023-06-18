package org.vivek.dp.lcsQuestions.palindromicSubsequenceQuestions;

import java.util.Arrays;

//this is the variant of longest common subsequence
//in this we just have to find the lcs of S and it's reverse string
//https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        int longestPalinSubseq = longestPalinSubseq(s);
        int longestPalinSubseqTopdown = longestPalinSubseqTopdown(s);
        System.out.println(longestPalinSubseq);
        System.out.println(longestPalinSubseqTopdown);
    }
    private static int longestPalinSubseqTopdown(String s1)
    {
        //code here
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0)
                   dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    private static int longestPalinSubseq(String s1)
    {
        //code here
        //this is the variant of longest common subsequence
        //in this we just have to find the lcs of S and it's reverse string
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        int n = s1.length();
        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return lcs(s1,s2,n,n,memo);
    }

    private static int lcs(String s1, String s2, int x, int y, int[][] memo){
        if(x == 0 || y == 0)
            return 0;
        if(memo[x][y] != -1) return memo[x][y];
        if(s1.charAt(x-1) == s2.charAt(y-1)) return memo[x][y] = 1 + lcs(s1,s2,x-1,y-1,memo);
        else return memo[x][y] = Math.max(lcs(s1,s2,x-1,y,memo),lcs(s1,s2,x,y-1,memo));
    }
}

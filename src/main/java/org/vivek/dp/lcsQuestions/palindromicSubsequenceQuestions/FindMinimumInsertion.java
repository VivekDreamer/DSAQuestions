package org.vivek.dp.lcsQuestions.palindromicSubsequenceQuestions;

import java.util.Arrays;
//same approach as that of deletion of elements to make a string palindromic
//https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1
public class FindMinimumInsertion {
    public static void main(String[] args) {
        String s = "abcd";
        int findMinInsertions = findMinInsertions(s);
        System.out.println(findMinInsertions);
        int findMinInsertionsTopdown = findMinInsertionsTopdown(s);
        System.out.println(findMinInsertionsTopdown);
    }
    private static int findMinInsertions(String S){
        // code here
        StringBuffer sb = new StringBuffer(S);
        String str = sb.reverse().toString();
        int[][] memo = new int[S.length()+1][S.length()+1];
        for(int[] row : memo)
            Arrays.fill(row , -1);
        int lcs = lcs(S,str,S.length(),str.length(),memo);
        return (S.length()-lcs);
    }
    private static int lcs(String str1, String str2, int n, int m, int[][] memo) {
        if(n == 0 || m == 0) return 0;
        if(memo[n][m] != -1) return memo[n][m];
        if(str1.charAt(n-1) == str2.charAt(m-1)) return memo[n][m] = 1 + lcs(str1,str2,n-1,m-1,memo);
        else return memo[n][m] = Math.max(lcs(str1,str2,n-1,m,memo) , lcs(str1,str2,n,m-1,memo));
    }
    private static int findMinInsertionsTopdown(String S){
        // code here
        StringBuffer sb = new StringBuffer(S);
        String str = sb.reverse().toString();
        int[][] dp = new int[S.length()+1][S.length()+1];
        for(int i = 0; i < S.length()+1; i++){
            for(int j = 0; j < S.length()+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < S.length()+1; i++){
            for(int j = 1; j < S.length()+1; j++){
                if(S.charAt(i-1) == str.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return (S.length()-dp[S.length()][S.length()]);
    }
}

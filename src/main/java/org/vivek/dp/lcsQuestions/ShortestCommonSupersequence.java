package org.vivek.dp.lcsQuestions;

import java.util.Arrays;

//idea is to take the letters which comes in lcs only one time
//in worst case, w can say, just concatenate both string and we will get common supersequence but that will be not smallest
//for smallest common supersequence, we have to take lcs only one time
//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String x = "abcd"; String y = "xycd";
        int m = 4, n = 4;
        int shortestCommonSupersequence = shortestCommonSupersequence(x, y, m, n);
        int shortestCommonSupersequenceTopdown = shortestCommonSupersequenceTopdown(x, y, m, n);
        System.out.println(shortestCommonSupersequence);
        System.out.println(shortestCommonSupersequenceTopdown);
    }
    public static int shortestCommonSupersequenceTopdown(String x,String y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return m+n-dp[m][n];
    }
    public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
        //Your code here
        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return m+n-lcsUtil(x,y,m,n,memo);
    }
    public static int lcsUtil(String x, String y, int m, int n, int[][] memo){
        if(m == 0 || n == 0) return 0;
        if(memo[m][n] != -1) return memo[m][n];
        if(x.charAt(m-1) == y.charAt(n-1)){
            return memo[m][n] = 1+lcsUtil(x,y,m-1,n-1,memo);
        }
        else return memo[m][n] = Math.max(lcsUtil(x,y,m-1,n,memo),lcsUtil(x,y,m,n-1,memo));
    }
}

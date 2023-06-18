package org.vivek.dp.lcsQuestions;
//this problem is same as lcs
//https://leetcode.com/problems/is-subsequence/description/
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
    public static boolean isSubsequence(String s, String t) {
        int lengthOfSubsequence = lcs(s,t,s.length(),t.length());
        if(s.length() == lengthOfSubsequence) return true;
        return false;
    }
    private static int lcs(String s, String t, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}

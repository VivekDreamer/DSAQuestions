package org.vivek.dp.lcsQuestions;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int x = 6; int y = 6;
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int lcs = lcs(x, y, s1, s2);
        int lcsTopDown = lcsTopDown(x, y, s1, s2);
        System.out.println(lcs);
        System.out.println(lcsTopDown);
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[][] memo = new int[x+1][y+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return lcsUtil(x,y,s1,s2,memo);
    }
    static int lcsUtil(int x, int y, String s1, String s2, int[][] memo){
        //base condition
        if(x == 0 || y == 0)
            return 0;
        if(memo[x][y] != -1)
            return memo[x][y];
        //choice diagram
        if(s1.charAt(x-1) == s2.charAt(y-1)){
            return memo[x][y] = 1 + lcsUtil(x-1,y-1,s1,s2,memo);
        }
        else{
            return memo[x][y] = Math.max(lcsUtil(x-1,y,s1,s2,memo) , lcsUtil(x,y-1,s1,s2,memo));
        }
    }
    static int lcsTopDown(int x, int y, String s1, String s2){
        int[][] dp = new int[x+1][y+1];
        for(int i = 0; i < x+1; i++){
            for(int j = 0; j < y+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < x+1; i++){
            for(int j = 1; j < y+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
}

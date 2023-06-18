package org.vivek.dp.lcsQuestions;

import java.util.Arrays;

//min operation required to convert String a to b
 //simple lcs problem
//we are converting String a to String b through lcs
//like heap -> pea
//lcs is ea
//so delete extra character in String a other than lcs i.e #deletion = len(a) - lcs = 4-2 = 2
//insert extra character in whatever we are getting from deletion operation. #insertion = len(b) - lcs = 3-2 = 1
//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
public class MinOperationRequired {
    public static void main(String[] args) {
        String a = "heap", b = "pea";
        int minOperation = minOperation(a,b); 
        System.out.println(minOperation);
        int minOperationsTopDown = minOperationsTopDown(a, b);
        System.out.println(minOperationsTopDown);
    }

    private static int minOperation(String a, String b) {
        int x = a.length(), y = b.length();
	    int[][] memo = new int[x+1][y+1];
	    for(int[] row : memo)
	        Arrays.fill(row,-1);
	    int lcs = lcs(a,b,x,y,memo);
	    return (x-lcs)+(y-lcs);
    }

    private static int lcs(String a, String b, int x, int y, int[][] memo) {
        if(x == 0 || y == 0) return 0;
	    if(memo[x][y] != -1) return memo[x][y];
	    if(a.charAt(x-1) == b.charAt(y-1))
	        return memo[x][y] = 1 + lcs(a,b,x-1,y-1,memo);
	    else
	        return memo[x][y] = Math.max(lcs(a,b,x-1,y,memo),lcs(a,b,x,y-1,memo));
    }

    public static int minOperationsTopDown(String a, String b) 
	{ 
	    // Your code goes here
	    //simple lcs problem
	    //we are converting String a to String b through lcs
	    //like heap -> pea
	    //lcs is ea
	    //so delete extra character in String a other than lcs i.e #deletion = len(a) - lcs = 4-2 = 2
	    //insert extra character in whatever we are getting from deletion operation. #insertion = len(b) - lcs = 3-2 = 1
	    int x = a.length(), y = b.length();
	    int[][] dp = new int[x+1][y+1];
        for(int i = 0; i < x+1; i++){
            for(int j = 0; j < y+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < x+1; i++){
            for(int j = 1; j < y+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (x-dp[x][y])+(y-dp[x][y]);
	}
}

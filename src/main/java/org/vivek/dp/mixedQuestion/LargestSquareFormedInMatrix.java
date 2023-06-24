package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
public class LargestSquareFormedInMatrix {
    int maxi = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int n = 2, m = 2;
        int[][] mat = {{1, 1}, 
                     {1, 1}};
        LargestSquareFormedInMatrix a = new LargestSquareFormedInMatrix();
        int maxSquare = a.maxSquare(n, m, mat);
        System.out.println(maxSquare);
        int maxSquareBottomUp = a.maxSquareBottomUp(n, m, mat);
        System.out.println(maxSquareBottomUp);
        int maxSquareSO = a.maxSquareSO(n, m, mat);
        System.out.println(maxSquareSO);
    }
    //memoization
    private int maxSquare(int n, int m, int mat[][]){
        // code here
        int[][] memo = new int[n+1][m+1];
        for(int[] row : memo)Arrays.fill(row,-1);
        maxSquareUtil(mat,0,0,memo);
        return maxi < 0? 0 : maxi;
    }
    private int maxSquareUtil(int mat[][], int i, int j, int[][] memo){
        if(i >= mat.length || j >= mat[0].length) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int right = maxSquareUtil(mat,i,j+1,memo);
        int diagonal = maxSquareUtil(mat,i+1,j+1,memo);
        int down = maxSquareUtil(mat,i+1,j,memo);
        if(mat[i][j] == 1){
            int ans = 1 + Math.min(right,Math.min(down,diagonal));
            maxi = Math.max(maxi,ans);
            return memo[i][j] = ans;
        }
        else return memo[i][j] = 0;
    }

    // bottom-up
    private int maxSquareBottomUp(int n, int m, int mat[][]){
        int[][] dp = new int[n+1][m+1];
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j >= 0; j--){
                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                int down = dp[i+1][j];
                if(mat[i][j] == 1){
                    dp[i][j] = 1 + Math.min(right,Math.min(down,diagonal));
                    maxi = Math.max(maxi,dp[i][j]);
                }
                else dp[i][j] = 0;
            }   
        }
        return maxi < 0 ? 0 : maxi;
    }
    //space-optimization
    private int maxSquareSO(int n, int m, int mat[][]){
        int[] curr = new int[m+1];
        int[] next = new int[m+1];
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j >= 0; j--){
                int right = curr[j+1];
                int diagonal = next[j+1];
                int down = next[j];
                if(mat[i][j] == 1){
                    curr[j] = 1 + Math.min(right,Math.min(down,diagonal));
                    maxi = Math.max(maxi,curr[j]);
                }
                else curr[j] = 0;
            }
            System.arraycopy(curr, 0, next, 0, m + 1);
        }
        return maxi < 0 ? 0 : maxi;
    }
}

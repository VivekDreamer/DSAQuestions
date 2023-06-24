package org.vivek.dp.mixedQuestion;
//https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
public class LCSOfThreeStrings {
    public static void main(String[] args) {
        String A = "geeks", B = "geeksfor", C = "geeksforgeeks";
        int lcsOfThreeStrings = lcsOfThreeStrings(A,B,C,A.length(),B.length(),C.length());
        System.out.println(lcsOfThreeStrings);
    }
    private static int lcsOfThreeStrings(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int[][][] dp = new int[n1+1][n2+1][n3+1];
        for(int i = 0; i < n1+1; i++){
            for(int j = 0; j < n2+1; j++){
                for(int k = 0; k < n3+1; k++ )
                {
                    if( i== 0 || j == 0 || k == 0)
                    dp[i][j][k] = 0;
                }
            }
        }
        for(int i = 1; i < n1+1; i++){
            for(int j = 1; j < n2+1; j++){
                for(int k = 1; k < n3+1; k++ )
                {
                    if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1)){
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    }
                    else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k],
                                        Math.max(dp[i-1][j-1][k],
                                            Math.max(dp[i][j-1][k-1],
                                                Math.max(dp[i][j-1][k],
                                                    Math.max(dp[i][j][k-1],dp[i-1][j][k-1])))));
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}

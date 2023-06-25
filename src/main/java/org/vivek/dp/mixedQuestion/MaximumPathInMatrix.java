package org.vivek.dp.mixedQuestion;

import java.util.Arrays;

public class MaximumPathInMatrix {
    public static void main(String[] args) {
        int N = 2;
        int[][] Matrix = {{348, 391},
                          {618, 193}};
        int maximumPathWES = maximumPathWES(N, Matrix);
        System.out.println(maximumPathWES);
    }

    //using memoization
    static int maximumPath(int N, int[][] Matrix){
        int[][] memo = new int[N+1][N+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            maxi = Math.max(maxi,maximumPathUtil(0,i,N,Matrix,memo));
        }
        return maxi;
    }
    static int maximumPathUtil(int i, int j ,int N, int[][] Matrix, int[][] memo){
        if(i < 0 || i >= N || j < 0 || j >= N) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        return memo[i][j] = Math.max(maximumPathUtil(i+1,j,N,Matrix,memo),
              Math.max(maximumPathUtil(i+1,j-1,N,Matrix,memo),
                        maximumPathUtil(i+1,j+1,N,Matrix,memo)))+Matrix[i][j];
    }

    //using bottom-up
    static int maximumPathBottomUp(int N, int[][] Matrix){
        int[][] dp = new int[N][N];
        for(int i = N-1; i>=0; i--){
            dp[N-1][i]=Matrix[N-1][i];
        }
        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                dp[i][j] = Math.max(dp[i+1][j],Math.max(j>0?dp[i+1][j-1]:0,
                            j<N-1?dp[i+1][j+1]:0))+Matrix[i][j];
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            maxi = Math.max(maxi,dp[0][i]);
        }
        return maxi;
    }

    //using space-optimization
    static int maximumPathSO(int N, int[][] Matrix){
        int[] dp = new int[N];
        int[] temp = new int[N];
        for(int i = N-1; i>=0; i--){
            temp[i]=Matrix[N-1][i];
        }
        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                dp[j] = Math.max(temp[j],Math.max(j>0?temp[j-1]:0,
                            j<N-1?temp[j+1]:0))+Matrix[i][j];
            }
            System.arraycopy(dp, 0, temp, 0, N);
        }
        
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            maxi = Math.max(maxi,temp[i]);
        }
        return maxi;
    }

    //by taking dp array, so that given matrix remains intact
    //without taking tertiary operator and here we started from toptoDown
    static int maximumPathTopDown(int N, int Matrix[][])
    {
        int dp[][] = new int[N][N];
        for(int i = 0;i < N;i++)
            dp[0][i] = Matrix[0][i];
            
        // calculating the path sums of the matrix
        for(int i = 1;i < N;i++){
            for(int j = 0;j < N;j++){
                if(j == 0 && j+1 < N)
                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],dp[i-1][j+1]);
                else if(j-1>=0 && j == N-1)
                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
                else if(j > 0 && j+1 < N)
                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i-1][j+1]));
                else
                    dp[i][j] = Matrix[i][j] + dp[i-1][j];
            }
        }
        
        // getting the maximum path sum
        int maxi = 0;
        for(int i = 0;i < N;i++)
            maxi = Math.max(maxi, dp[N-1][i]);
        
        return maxi;
    }

    //without taking extra space
    static int maximumPathWES(int N, int Matrix[][])
    {
        // code here
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N; j++){
                //any path can be taken
                // if(j > 0 && j < N-1)
                //     Matrix[i][j] += Math.max(Matrix[i-1][j], Math.max(Matrix[i-1][j-1] , Matrix[i-1][j+1]));
                //down right path is not possible
                // else if(j > 0)
                //     Matrix[i][j] += Math.max(Matrix[i-1][j] , Matrix[i-1][j-1]);
                //down left path is not possible
                // else 
                //     Matrix[i][j] += Math.max(Matrix[i-1][j] , Matrix[i-1][j+1]);

                //or above three condition can be merge in one using tertiary operator
                Matrix[i][j] += Math.max(Matrix[i-1][j],Math.max(j>0?Matrix[i-1][j-1]:0,
                            j<N-1?Matrix[i-1][j+1]:0));
            }
        }
        int ans = 0;
        for(int j = 0; j < N; j++)
            ans = Math.max(ans,Matrix[N-1][j]);
        return ans;
    }
}

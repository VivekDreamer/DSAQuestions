package org.vivek.dp.mcm;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int n = 5;  
        int[] arr = {40, 20, 30, 10, 30};
        int matrixMultiplication = matrixMultiplication(n, arr);
        System.out.println(matrixMultiplication);
    }
    public static int matrixMultiplication(int N, int arr[])
    {
        // code here
        //recursive approach
        //step 1 : find i and j
        //step 2 : find valid base condition
        //step 3 : move k from i to j and call for appropriate sub problems
        int i = 1;
        int j = N-1;
        int[][] memo = new int[N+1][N+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return solve(arr ,i ,j, memo);
    }
    public static int solve(int[] arr, int i, int j, int[][] memo)
    {
        if(i >= j) return 0; //base condition
        if(memo[i][j] != -1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = solve(arr, i, k, memo) 
                     + solve(arr, k+1, j, memo)
                     + arr[i-1] * arr[k] * arr[j];
            if(temp < min)
                min = temp;
        }
        return memo[i][j] = min;
    }
}

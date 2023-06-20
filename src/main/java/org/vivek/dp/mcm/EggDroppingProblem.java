package org.vivek.dp.mcm;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/0
public class EggDroppingProblem {
    public static void main(String[] args) {
        int n = 1, k = 2;
        int eggDrop = eggDrop(n, k);
        System.out.println(eggDrop);
    }
    private static int eggDrop(int n, int k){
        int[][] memo = new int[n+1][k+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return eggDropUtil(n,k,memo);
    }
    private static int eggDropUtil(int n, int k, int[][] memo) {
        if(k == 0 || k == 1) return k;
        if(n == 1) return k;
        if(memo[n][k] != -1) return memo[n][k];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            int temp = 1+Math.max(eggDropUtil(n-1,i-1,memo), eggDropUtil(n, k-i, memo));
            min = Math.min(min, temp);
        }
        return memo[n][k] = min;
    }
}

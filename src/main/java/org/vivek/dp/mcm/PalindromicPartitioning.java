package org.vivek.dp.mcm;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class PalindromicPartitioning {
    public static void main(String[] args) {
        String str = "nitik";
        int palindromicPartition = palindromicPartition(str);
        System.out.println(palindromicPartition);
    }
    private static int palindromicPartition(String str)
    {
        // code here
        int i = 0;
        int j = str.length()-1;
        int[][] memo = new int[str.length()][str.length()];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return solve(str,i,j,memo);
    }
    private static int solve(String str, int i, int j, int[][] memo){
        if(i >= j) return 0;
        if(isPalindrome(str,i,j)) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = 1 + solve(str,i,k,memo) + solve(str,k+1,j,memo);
            min = Math.min(min,temp);
        }
        return memo[i][j] = min;
    }
    private static boolean isPalindrome(String str, int i, int j){
        if(i == j)return true;
        if(i > j)return true;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

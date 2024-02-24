package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/maximum-sum-problem2211/1
public class POTD_MaximumSumProblem {
    public int maxSum(int n) { 
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return maxSumUtil(n,memo);
    } 
    public int maxSumUtil(int n, int[] memo){
        if(n == 1 || n == 0) return n;
        if(memo[n] != -1) return memo[n];
        int a = maxSumUtil(n/2, memo);
        int b = maxSumUtil(n/3, memo);
        int c = maxSumUtil(n/4, memo);
        return memo[n] = Math.max(n,(a+b+c));
    }
}

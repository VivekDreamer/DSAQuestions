package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

public class Leetcode_LongestIncreasingSubsequence {
    /*
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISUtil(0,-1,nums);
    }
    public int lengthOfLISUtil(int idx, int prevIdx, int[] nums){
        if(idx == nums.length) return 0; //we are returning the length of LIS
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            take = 1 + lengthOfLISUtil(idx+1, idx, nums);
        }
        int skip = lengthOfLISUtil(idx+1, prevIdx, nums);
        return Math.max(take,skip);
    }
    */
    
    /*
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length+1][nums.length+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return lengthOfLISUtil(0,-1,nums);
    }
    public int lengthOfLISUtil(int idx, int prevIdx, int[] nums){
        if(idx >= nums.length) return 0; //we are returning the length of LIS
        if(prevIdx != -1 && memo[idx][prevIdx] != -1) return memo[idx][prevIdx];
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            take = 1 + lengthOfLISUtil(idx+1, idx, nums);
        }
        int skip = lengthOfLISUtil(idx+1, prevIdx, nums);
        if(prevIdx != -1) memo[idx][prevIdx] = Math.max(take,skip);
        return Math.max(take,skip);
    }
    */
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLis = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxLis = Math.max(dp[i],maxLis);
                }
            }
        }
        return maxLis;
    }
}

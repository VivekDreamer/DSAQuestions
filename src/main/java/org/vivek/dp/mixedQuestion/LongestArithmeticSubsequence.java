package org.vivek.dp.mixedQuestion;

import java.util.Arrays;

//question related to Longest increasing subsequence
//https://leetcode.com/problems/longest-arithmetic-subsequence/description/
public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = {20,1,15,3,10,5,8};
        int longestArithSeqLength = longestArithSeqLength(nums);
        System.out.println(longestArithSeqLength);
        int longestArithSeqLengthDP = longestArithSeqLengthDP(nums);
        System.out.println(longestArithSeqLengthDP);
    }
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int[][] memo = new int[1001][1001];
        for(int[] row : memo) Arrays.fill(row,-1);
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int diff = nums[j] - nums[i];
                result = Math.max(result , 2 + solve(nums,i,diff, memo));
            }
        }
        return result;
    }
    private static int solve(int[] nums, int i, int diff, int[][] memo) {
        if(i < 0) return 0;
        if(memo[i][diff+501] != -1) return memo[i][diff+501];
        int ans = 0;
        for(int k = i-1; k >= 0; k--){
            //going left side
            if(nums[i] - nums[k] == diff)
                ans = Math.max(ans, 1 + solve(nums, k, diff, memo));
        }
        return ans;
    }

    public static int longestArithSeqLengthDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int result = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = dp[j][diff] > 0 ? 1 + dp[j][diff] : 2;
                result = Math.max(result, dp[i][diff]);
            }
        }
        return result;
    }
}

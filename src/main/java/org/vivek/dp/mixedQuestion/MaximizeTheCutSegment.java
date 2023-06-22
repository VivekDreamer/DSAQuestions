package org.vivek.dp.mixedQuestion;

import java.util.Arrays;

public class MaximizeTheCutSegment {
    public static void main(String[] args) {
        int N = 4 , x = 2, y = 1, z = 1;
        int[] memo = new int[N+1];
        Arrays.fill(memo,-1);
        int maximizeCuts = maximizeCuts(N, x, y, z, memo);
        System.out.println(maximizeCuts);
        int maximizeCutsTopdown = maximizeCutsTopdown(N, x, y, z);
        System.out.println(maximizeCutsTopdown);
    }
    private static int maximizeCuts(int n, int x, int y, int z, int[] memo){
        if(n <= 0) return 0;
        if(memo[n] != -1) return memo[n];
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Integer.MIN_VALUE;
        if(n>=x) ans1 = maximizeCuts(n-x, x, y, z, memo);
        if(n>=y) ans2 = maximizeCuts(n-y, x, y, z, memo);
        if(n>=z) ans3 = maximizeCuts(n-z, x, y, z, memo);
        return memo[n] = Math.max(ans1,Math.max(ans2, ans3)) + 1;
    }
    private static int maximizeCutsTopdown(int n, int x, int y, int z)
    {
      //Your code here
      int[] dp = new int[n+1];
      int i=1;
      while(i<=n){
        int ans1=Integer.MIN_VALUE;
        int ans2=Integer.MIN_VALUE;
        int ans3=Integer.MIN_VALUE;
        if(i>=x)ans1=dp[i-x];
        if(i>=y)ans2=dp[i-y];
        if(i>=z)ans3=dp[i-z];
        dp[i] = 1+Math.max(ans1,Math.max(ans2,ans3));
        i++;
      }
      return dp[n]<0?0:dp[n];
    }
}

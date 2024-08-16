// https://www.geeksforgeeks.org/problems/cutted-segments1642/1
class POTD_MinimizeCutSegments
{
    //Function to find the maximum number of cuts.
    // public int maximizeCuts(int n, int x, int y, int z)
    // {
    //   //Your code here
    //   int[] memo = new int[n+1];
    //   Arrays.fill(memo,-1);
    //   int ans=maximizeCutsUtil(n,x,y,z,memo);
    //   return ans<0?0:ans;
    // }
    // public int maximizeCutsUtil(int n, int x, int y, int z, int[] memo){
    //     if(n <= 0) return 0;
    //     if(memo[n] != -1) return memo[n];
    //     int ans1=Integer.MIN_VALUE;
    //     int ans2=Integer.MIN_VALUE;
    //     int ans3=Integer.MIN_VALUE;
    //     if(n>=x)ans1=maximizeCutsUtil(n-x,x,y,z,memo);
    //     if(n>=y)ans2=maximizeCutsUtil(n-y,x,y,z,memo);
    //     if(n>=z)ans3=maximizeCutsUtil(n-z,x,y,z,memo);
    //     return memo[n] = 1+Math.max(ans1,Math.max(ans2,ans3));
    // }
    public int maximizeCuts(int n, int x, int y, int z)
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

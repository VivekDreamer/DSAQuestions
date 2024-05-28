// https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1
class POTD_MinimumCostToFillGivenWeightInBag {    
  public static int minimumCost(int N, int W, int[] cost)
	{
		// Your code goes here
		int[][] memo=new int[N+1][W+1];
		for(int row[]:memo)Arrays.fill(row,-1);
		int ans=minimumCostUtil(cost,N,W,memo);
		return (ans==(int)(1e8)?-1:ans);
	}

	public static int minimumCostUtil(int cost[], int N,int W,int[][] memo){
	    if(W == 0) return 0;
	    if(N == 0) return (int)1e8;
	    if(memo[N][W]!=-1)return memo[N][W];
	    int ans = Integer.MAX_VALUE;
	    if(N<=W && cost[N-1]!=-1){
	        int temp=minimumCostUtil(cost,N,W-N,memo);
	        ans = temp+cost[N-1];
	    }
	     memo[N][W] = Math.min(ans,minimumCostUtil(cost,N-1,W,memo));
	     return memo[N][W];
	}

// 	public int minimumCost(int cost[], int N,int W)
// 	{
// 	    int[][] dp = new int[N+1][W+1];
// 	    for(int i = 0; i < W+1; i++)dp[0][i] = (int)(1e8);
// 	    for(int i = 0; i < N+1; i++)dp[i][0] = 0;
// 	    for(int i = 1; i < N+1; i++){
// 	        for(int j = 1; j < W+1; j++){
// 	            int ans = Integer.MAX_VALUE;
// 	            if(i<=j && cost[i-1]!=-1)
// 	                ans = cost[i-1]+dp[i][j-i];
// 	           dp[i][j] = Math.min(ans,dp[i-1][j]);
// 	       }
// 	    }
// 	    return dp[N][W]==(int)(1e8)?-1:dp[N][W];
// 	}
}

class POTD_MinCostClimbingStairs {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n=cost.length;
        for(int i=2;i<n;i++)cost[i]+=Math.min(cost[i-1],cost[i-2]);
        return Math.min(cost[n-1],cost[n-2]);
    }
};

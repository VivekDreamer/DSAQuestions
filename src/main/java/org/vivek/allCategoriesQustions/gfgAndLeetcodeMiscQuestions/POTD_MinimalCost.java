// https://www.geeksforgeeks.org/problems/minimal-cost/1
class POTD_MinimalCost {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        
        // dp[i] will store the minimum cost to reach stone i
        int[] dp = new int[n];
        
        // Initialize the dp array to a large number initially
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Starting at the first stone with 0 cost
        dp[0] = 0;
        
        // Fill the dp array using the recurrence relation
        for (int i = 1; i < n; i++) {
            // Check all stones from i-1 to i-k and find the minimum cost
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                }
            }
        }
        
        // The result is the minimum cost to reach the last stone
        return dp[n - 1];
    }
}

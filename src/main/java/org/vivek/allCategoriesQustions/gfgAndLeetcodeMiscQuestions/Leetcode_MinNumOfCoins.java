class Leetcode_MinNumOfCoins {
    int[][] memo;
    public int minCoins(int coins[], int sum) {
        coins = Arrays.stream(coins).filter(coin -> coin > 0).toArray();
        memo = new int[coins.length+1][sum+1];
        for(int[] rows : memo) Arrays.fill(rows,-1);
        int res = minCoinsUtil(coins, sum, coins.length);
        return (res == Integer.MAX_VALUE - 1) ? -1 : res;
    }
    public int minCoinsUtil(int[] coins, int sum, int n){
        if(sum == 0) memo[n][sum] = 0;
        if(n == 0) memo[n][sum] = Integer.MAX_VALUE - 1;
        if(memo[n][sum] != -1) return memo[n][sum];
        int res = minCoinsUtil(coins, sum, n-1);
        if(coins[n-1] <= sum){
            res = Math.min(res, 1 + minCoinsUtil(coins, sum-coins[n-1], n));
        }
        return memo[n][sum] = res;
    }
    /*public int minCoins(int coins[], int sum) {
        coins = Arrays.stream(coins).filter(coin -> coin > 0).toArray();
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
        //here i represents the n which is number of elements in array
        //here j represents the sum
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(j == 0)
                    dp[i][j] = 0;
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        //initialising the second row
        for(int i = 1; i < 2; i++){
            for(int j = 1; j < sum+1; j++){
                if(j % coins[0] == 0)
                    dp[i][j] = j/coins[0];
                else
                    dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(coins[i-1] <= j)
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum] == (Integer.MAX_VALUE -1) ? -1 : dp[n][sum];
    }*/
}

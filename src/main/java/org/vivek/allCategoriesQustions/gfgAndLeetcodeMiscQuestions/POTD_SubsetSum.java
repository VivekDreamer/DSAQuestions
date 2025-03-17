class POTD_SubsetSum {
    static Boolean isSubsetSum(int arr[], int target) {
        boolean[][] dp = new boolean[arr.length+1][target+1];
        for(int i = 0; i < arr.length+1; i++){
            for(int j = 0; j < target+1; j++){
                if(i == 0) dp[i][j] = false; //0 elements and sum anything
                if(j == 0) dp[i][j] = true;  //any elemnts and sum 0
            }
        }
        for(int i = 1; i < arr.length+1; i++){
            for(int j = 0; j < target+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][target];
    }
}
